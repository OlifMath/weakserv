package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Service;

import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Models.MovimentoCaixa;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecRegistraTransacao;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecResumoTransacao;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Repository.MovimentoFinanceiroRepository;
import br.com.dunasdev.WeakServApi.Shared.Core.Service.CoreService;
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
        var planilha = CoreService.buscaPlanilha();

        var transacao = new MovimentoCaixa();

        transacao.setPlanilha(planilha);
        transacao.setMovimento(novaTransacao.dataMovimento().atStartOfDay());
        transacao.setUsuario("ADMIN");

        //pretendo mudar isso no futuro para fazer busca de Historico no banco e deixar o processo mais dinâmico
        if(novaTransacao.codHistorico().compareTo(BigDecimal.ZERO) == 0) {
            transacao.setHistorico(BigDecimal.valueOf(14)); //Saida
            transacao.setSaida(novaTransacao.valor());
            transacao.setContrapartida(
                contrapartidaService.buscarContrapartida(novaTransacao.caixa(), "E")
            );
        }
        else{
            transacao.setHistorico(BigDecimal.valueOf(13)); //Entrada
            transacao.setSaida(novaTransacao.valor());
            transacao.setContrapartida(
                contrapartidaService.buscarContrapartida(novaTransacao.caixa(), "S")
            );
        }

        transacao.setComplemento(novaTransacao.complemento());
        transacao.setEmpresa(1);
        transacao.setCaixa(novaTransacao.caixa());
        transacao.setCentroResultados(novaTransacao.contaResultado());
        transacao.setOrigem("AP");
        transacao.setDataHoraServer(LocalDateTime.now());

        var transacaoSalva = movRepository.save(transacao);

        return movRepository.buscarTransacaoById(transacaoSalva.getCodInterno());
    }
}
