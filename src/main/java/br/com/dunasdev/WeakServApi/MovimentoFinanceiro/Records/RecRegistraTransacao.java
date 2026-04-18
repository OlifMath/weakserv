package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RecRegistraTransacao(
    LocalDateTime dataMovimento,
    BigDecimal codHistorico,
    BigDecimal contaResultado,
    String complemento,
    Integer Empresa,
    BigDecimal Caixa
)
{}
