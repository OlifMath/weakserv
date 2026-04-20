package br.com.dunasdev.WeakServApi.ContasReceber.Records;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RecLancaContasReceber(
        BigDecimal codCliente,
        LocalDate dataEmissao,
        BigDecimal formaPagamento,
        BigDecimal centroResultados,
        BigDecimal valorTotal,
        Integer numeroParcelas,
        TipoIntervalo tipoIntervalo,
        Integer intervalo,
        LocalDate primeiroVencimento
) {
}
