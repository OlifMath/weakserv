package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Service;

import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Models.MovimentoCaixa;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecRegistraTransacao;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecResumoTransacao;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Repository.MovimentoFinanceiroRepository;
import br.com.dunasdev.WeakServApi.Shared.Core.BuscaPlanilha.Service.BuscaPlanilhaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimentoFinanceiroService {

    private final MovimentoFinanceiroRepository movRepository;
    private final HistoricosCaixaContrapartidaService contrapartidaService;

    public MovimentoFinanceiroService(MovimentoFinanceiroRepository movRepository, HistoricosCaixaContrapartidaService contrapartidaService) {
        this.movRepository = movRepository;
        this.contrapartidaService = contrapartidaService;
    }

    public List<RecResumoTransacao> listarTransacoes(LocalDateTime inicio, LocalDateTime fim) {
        var inicioCalc = inicio.withDayOfMonth(1).toLocalDate().atStartOfDay();
        var fimCalc = fim.withDayOfMonth(fim.toLocalDate().lengthOfMonth()).toLocalDate().atTime(23, 59, 59);

        return movRepository.listarTransacoes(inicioCalc, fimCalc);
    }

    public RecResumoTransacao registrarTransacao(RecRegistraTransacao novaTransacao) {
        var planilha = BuscaPlanilhaService.buscaPlanilha();
        var transacao = new MovimentoCaixa();

        transacao.setPlanilha(planilha);
        transacao.setMovimento(novaTransacao.dataMovimento().atStartOfDay());
        transacao.setUsuario("ADMIN");
        transacao.setComplemento(novaTransacao.complemento());
        transacao.setEmpresa(1);
        transacao.setCaixa(novaTransacao.caixa());
        transacao.setCentroResultados(novaTransacao.contaResultado());
        transacao.setOrigem("AP");
        transacao.setDataHoraServer(LocalDateTime.now());
        transacao.setCompetencia(LocalDateTime.now());
        transacao.setDataApresentacaoCheque(LocalDateTime.now());
        transacao.setEliminado(false);
        transacao.setCompensado(true);
        transacao.setDRE(true);

        // Campos não utilizados neste fluxo — definidos explicitamente como nulo/zero
        transacao.setEliminadoPor(null);
        transacao.setMotivo(null);
        transacao.setBordero(null);
        transacao.setDataEliminacao(null);
        transacao.setChequeEmitido(null);
        transacao.setCodRetorno(null);
        transacao.setDataCompensacao(null);
        transacao.setLogAlteracoes(null);
        transacao.setConciliado(null);
        transacao.setCodFatLote(null);
        transacao.setPlaVinculoOFX(null);
        transacao.setIDTransPJ(null);
        transacao.setTransPJStatus(null);

        // pretendo mudar isso no futuro para fazer busca de Histórico no banco
        if (novaTransacao.codHistorico().compareTo(BigDecimal.ZERO) == 0) {
            transacao.setHistorico(BigDecimal.valueOf(14)); // Saída

            transacao.setEntrada(BigDecimal.ZERO);
            transacao.setSaida(novaTransacao.valor());

            transacao.setContrapartida(
                    contrapartidaService.buscarContrapartida(novaTransacao.caixa(), "E")
            );
        } else {
            transacao.setHistorico(BigDecimal.valueOf(13)); // Entrada

            transacao.setEntrada(novaTransacao.valor());
            transacao.setSaida(BigDecimal.ZERO);

            transacao.setContrapartida(
                    contrapartidaService.buscarContrapartida(novaTransacao.caixa(), "S")
            );
        }

        var transacaoSalva = movRepository.save(transacao);
        return movRepository.buscarTransacaoById(transacaoSalva.getCodInterno());
    }
}
