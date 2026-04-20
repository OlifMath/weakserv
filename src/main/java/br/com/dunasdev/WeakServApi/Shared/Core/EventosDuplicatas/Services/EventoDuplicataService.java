package br.com.dunasdev.WeakServApi.Shared.Core.EventosDuplicatas.Services;

import br.com.dunasdev.WeakServApi.ContasPagar.Repository.ContasPagarRepository;
import br.com.dunasdev.WeakServApi.ContasReceber.Repository.ContasReceberRepository;
import br.com.dunasdev.WeakServApi.Shared.Exceptions.NaoEncontradoException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EventoDuplicataService {

    //region Atributos
    private final ContasReceberRepository contasReceberRepository;
    private final ContasPagarRepository contasPagarRepository;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    //endregion

    //region Construtores
    public EventoDuplicataService(ContasReceberRepository contasReceberRepository,
                                   ContasPagarRepository contasPagarRepository) {
        this.contasReceberRepository = contasReceberRepository;
        this.contasPagarRepository = contasPagarRepository;
    }
    //endregion

    //region Métodos

    //region Gravar Evento
    public void gravar(String tabela, BigDecimal codInterno, String ocorrencia) {
        String dataHora = LocalDateTime.now().format(FORMATTER);
        String entrada = "<ADMIN " + dataHora + "> " + ocorrencia + "\r\n";

        if ("R".equals(tabela)) {
            var registro = contasReceberRepository.findByCodInterno(codInterno)
                    .orElseThrow(() -> new NaoEncontradoException(
                            "ContasReceber não encontrado com CodInterno: " + codInterno));

            String eventoAtual = registro.getEventosDuplicata();
            registro.setEventosDuplicata(eventoAtual != null ? eventoAtual + entrada : entrada);
            contasReceberRepository.save(registro);
        } else {
            var registro = contasPagarRepository.findByCodInterno(codInterno)
                    .orElseThrow(() -> new NaoEncontradoException(
                            "ContasPagar não encontrado com CodInterno: " + codInterno));

            String eventoAtual = registro.getEventosDuplicata();
            registro.setEventosDuplicata(eventoAtual != null ? eventoAtual + entrada : entrada);
            contasPagarRepository.save(registro);
        }
    }
    //endregion

    //endregion
}
