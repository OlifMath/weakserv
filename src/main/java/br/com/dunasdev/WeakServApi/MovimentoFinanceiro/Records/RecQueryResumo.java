package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records;

import java.math.*;
import java.time.LocalDateTime;

public record RecQueryResumo(
        LocalDateTime movimento,
        BigDecimal entrada,
        BigDecimal saida,
        String complemento,
        String historico,
        String descreveContrapartida,
        String descreveCaixa,
        String descricaoSubConta
) {}