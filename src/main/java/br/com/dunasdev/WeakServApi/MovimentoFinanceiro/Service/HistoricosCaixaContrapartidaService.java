package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Service;

import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Models.HistoricosCaixaContrapartida;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Repository.HistoricosCaixaContrapartidaRepository;
import br.com.dunasdev.WeakServApi.Shared.Exceptions.NaoEncontradoException;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class HistoricosCaixaContrapartidaService {

    private final HistoricosCaixaContrapartidaRepository contrapartidaRepository;

    public HistoricosCaixaContrapartidaService(HistoricosCaixaContrapartidaRepository contrapartidaRepository){
        this.contrapartidaRepository = contrapartidaRepository;
    }

    public BigDecimal buscarContrapartida(BigDecimal codCaixa, String entSai) {

        return contrapartidaRepository.buscarContrapartida(codCaixa, entSai)
                .map(HistoricosCaixaContrapartida::getCodContrapartida)
                .orElseThrow(() -> new NaoEncontradoException("Contrapartida não encontrada para o caixa " + codCaixa));
    }
}
