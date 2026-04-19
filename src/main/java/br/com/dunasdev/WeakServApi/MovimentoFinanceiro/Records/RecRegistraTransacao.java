package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RecRegistraTransacao(
    LocalDate dataMovimento,
    BigDecimal codHistorico,
    BigDecimal contaResultado,
    String complemento,
    BigDecimal empresa,
    BigDecimal caixa,
    BigDecimal valor
)
{}
