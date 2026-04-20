package br.com.dunasdev.WeakServApi.ContasPagar.Services;

import br.com.dunasdev.WeakServApi.Clientes.Repository.ClientesRepository;
import br.com.dunasdev.WeakServApi.ContasPagar.Models.ContasPagar;
import br.com.dunasdev.WeakServApi.ContasPagar.Records.RecLancaContasPagar;
import br.com.dunasdev.WeakServApi.ContasPagar.Records.RecResumoContasPagar;
import br.com.dunasdev.WeakServApi.ContasPagar.Repository.ContasPagarRepository;
import br.com.dunasdev.WeakServApi.ContasReceber.Records.TipoIntervalo;
import br.com.dunasdev.WeakServApi.Shared.Exceptions.NaoEncontradoException;
import br.com.dunasdev.WeakServApi.Shared.Exceptions.ValidacaoException;
import br.com.dunasdev.WeakServApi.Shared.Core.BuscaPlanilha.Service.CoreService;
import br.com.dunasdev.WeakServApi.Shared.Core.EventosDuplicatas.Services.EventoDuplicataService;
import br.com.dunasdev.WeakServApi.Shared.Utils.DataUtils;
import br.com.dunasdev.WeakServApi.Shared.Core.Feriados.FeriadosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContasPagarService {

    //region Atributos
    private final ContasPagarRepository contasPagarRepository;
    private final ClientesRepository clientesRepository;
    private final FeriadosRepository feriadosRepository;
    private final EventoDuplicataService eventoDuplicataService;
    //endregion

    //region Construtores
    public ContasPagarService(ContasPagarRepository contasPagarRepository,
                               ClientesRepository clientesRepository,
                               FeriadosRepository feriadosRepository,
                               EventoDuplicataService eventoDuplicataService) {
        this.contasPagarRepository = contasPagarRepository;
        this.clientesRepository = clientesRepository;
        this.feriadosRepository = feriadosRepository;
        this.eventoDuplicataService = eventoDuplicataService;
    }
    //endregion

    //region Métodos

    //region Lançar
    @Transactional
    public List<RecResumoContasPagar> lancar(RecLancaContasPagar request) {

        //region Validações
        if (request.codFornecedor() == null) {
            throw new ValidacaoException("O código do fornecedor é obrigatório.");
        }
        clientesRepository.findByCodCliente(request.codFornecedor().intValue())
                .orElseThrow(() -> new NaoEncontradoException(
                        "Fornecedor não encontrado com código: " + request.codFornecedor()));

        if (request.numeroParcelas() == null || request.numeroParcelas() <= 0) {
            throw new ValidacaoException("O número de parcelas é obrigatório e deve ser maior que zero.");
        }
        if (request.valorTotal() == null || request.valorTotal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidacaoException("O valor total é obrigatório e deve ser maior que zero.");
        }
        if (request.dataEmissao() == null) {
            throw new ValidacaoException("A data de emissão é obrigatória.");
        }
        if (request.formaPagamento() == null) {
            throw new ValidacaoException("A forma de pagamento é obrigatória.");
        }
        if (request.centroResultados() == null) {
            throw new ValidacaoException("O centro de resultados é obrigatório.");
        }
        if (request.contaVinculada() == null) {
            throw new ValidacaoException("A conta vinculada é obrigatória para contas a pagar.");
        }
        //endregion

        //region Cálculos gerais
        var planilha = CoreService.buscaPlanilha();
        Long maxNumero = contasPagarRepository.buscarMaxNumero();
        long proximoNumero = (maxNumero != null ? maxNumero : 0L) + 1;

        BigDecimal valorParcela = request.valorTotal()
                .divide(BigDecimal.valueOf(request.numeroParcelas()), 2, RoundingMode.HALF_UP);
        //endregion

        //region Geração de parcelas
        List<RecResumoContasPagar> resultado = new ArrayList<>();

        for (int i = 0; i < request.numeroParcelas(); i++) {
            String numero = String.valueOf(proximoNumero + i);
            String letra = DataUtils.geraLetra(i);

            LocalDate vencimentoOriginal = calcularVencimento(request.primeiroVencimento(), request.tipoIntervalo(), request.intervalo(), i);
            LocalDate vencimentoAjustado = DataUtils.ajustaVencimento(vencimentoOriginal, feriadosRepository);

            ContasPagar parcela = new ContasPagar();
            parcela.setEmpresa("1");
            parcela.setOperacao("AvulsoAPI");
            parcela.setSerie("Avul");
            parcela.setUsuario("ADMIN");
            parcela.setFornecedor(request.codFornecedor());
            parcela.setNotaFiscal(BigDecimal.valueOf(Long.parseLong(numero)));
            parcela.setNumero(numero);
            parcela.setLetra(letra);
            parcela.setDataEmissao(request.dataEmissao().atStartOfDay());
            parcela.setFormaPagamento(request.formaPagamento());
            parcela.setCentroResultados(request.centroResultados());
            parcela.setContaVinculada(request.contaVinculada());
            parcela.setValorDuplicata(valorParcela);
            parcela.setSaldo(valorParcela);
            parcela.setVencimento(vencimentoAjustado.atStartOfDay());
            parcela.setVencimentoOriginal(vencimentoOriginal.atStartOfDay());
            parcela.setPago(false);
            parcela.setImpresso(false);
            parcela.setAgrupada(false);
            parcela.setSelecionada(false);
            parcela.setRemessa(false);
            parcela.setCredito(BigDecimal.ZERO);
            parcela.setDebito(BigDecimal.ZERO);
            parcela.setAcrescimosFinanceiros(BigDecimal.ZERO);
            parcela.setLiberado(false);
            parcela.setLiberadoHolding(false);
            parcela.setConfirmado(false);
            parcela.setLiberaStatus("PE");
            parcela.setDataLancamento(LocalDateTime.now());
            parcela.setPlanilha(planilha);

            ContasPagar parcelaSalva = contasPagarRepository.save(parcela);

            eventoDuplicataService.gravar("P", parcelaSalva.getCodInterno(),
                    "Geração da duplicata via API - WeakServ");

            resultado.add(new RecResumoContasPagar(
                    parcelaSalva.getCodInterno(),
                    parcelaSalva.getNumero(),
                    parcelaSalva.getLetra(),
                    parcelaSalva.getVencimento(),
                    parcelaSalva.getValorDuplicata(),
                    parcelaSalva.getCentroResultados()
            ));
        }
        //endregion

        return resultado;
    }
    //endregion

    //region Calcular Vencimento
    private LocalDate calcularVencimento(LocalDate primeiroVencimento, TipoIntervalo tipoIntervalo, int intervalo, int indiceParcela) {
        if (indiceParcela == 0) {
            return primeiroVencimento;
        }
        if (tipoIntervalo == TipoIntervalo.DIAS) {
            return primeiroVencimento.plusDays((long) intervalo * indiceParcela);
        } else {
            return ajustaUltimoDiaMes(primeiroVencimento, intervalo * indiceParcela);
        }
    }
    //endregion

    //region Ajusta Último Dia do Mês
    private LocalDate ajustaUltimoDiaMes(LocalDate base, int meses) {
        LocalDate resultado = base.plusMonths(meses);
        int diaOriginal = base.getDayOfMonth();
        int maxDia = resultado.lengthOfMonth();
        if (diaOriginal > maxDia) {
            resultado = resultado.withDayOfMonth(maxDia);
        } else {
            resultado = resultado.withDayOfMonth(diaOriginal);
        }
        return resultado;
    }
    //endregion

    //endregion
}
