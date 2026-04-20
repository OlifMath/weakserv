package br.com.dunasdev.WeakServApi.ContasPagar.Records;

import br.com.dunasdev.WeakServApi.ContasReceber.Records.TipoIntervalo;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RecLancaContasPagar(
        BigDecimal codFornecedor,
        LocalDate dataEmissao,
        BigDecimal formaPagamento,
        BigDecimal centroResultados,
        BigDecimal contaVinculada,
        BigDecimal valorTotal,
        Integer numeroParcelas,
        TipoIntervalo tipoIntervalo,
        Integer intervalo,
        LocalDate primeiroVencimento
) {
}
