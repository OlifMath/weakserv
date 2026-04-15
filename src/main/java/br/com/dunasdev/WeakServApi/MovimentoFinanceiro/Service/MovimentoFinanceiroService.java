package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Service;

import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecQueryResumo;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Repository.MovimentoFinanceiroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimentoFinanceiroService {

    private final MovimentoFinanceiroRepository movRepository;

    public MovimentoFinanceiroService(MovimentoFinanceiroRepository movRepository) {
        this.movRepository = movRepository;
    }

    public List<RecQueryResumo> listarMovimentacoes(LocalDateTime inicio, LocalDateTime fim) {
        var inicioCalc = inicio.withDayOfMonth(1).toLocalDate().atStartOfDay();
        var fimCalc = fim.withDayOfMonth(fim.toLocalDate().lengthOfMonth()).toLocalDate().atTime(23, 59, 59);

        return movRepository.listarMovimentacoes(inicioCalc, fimCalc);
    }
}
