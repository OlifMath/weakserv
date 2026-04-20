package br.com.dunasdev.WeakServApi.ContasPagar.Records;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RecResumoContasPagar(
        BigDecimal codInterno,
        String numero,
        String letra,
        LocalDateTime vencimento,
        BigDecimal valorDuplicata,
        BigDecimal centroResultados
) {
}
