package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records;

import br.com.dunasdev.WeakServApi.Clientes.Records.RecResponse;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Models.MovimentoCaixa;

import java.math.*;
import java.time.LocalDateTime;
import java.util.List;

public record RecResumoTransacao(
        LocalDateTime movimento,
        BigDecimal entrada,
        BigDecimal saida,
        String complemento,
        String historico,
        String descreveContrapartida,
        String descreveCaixa,
        String descricaoSubConta
) {

}