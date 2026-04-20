package br.com.dunasdev.WeakServApi.ContasReceber.Records;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RecResumoContasReceber(
        BigDecimal codInterno,
        String numero,
        String letra,
        LocalDateTime vencimento,
        BigDecimal valorDuplicata,
        BigDecimal centroResultados
) {
}
