package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Repository;

import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Models.MovimentoCaixa;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecQueryResumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface MovimentoFinanceiroRepository extends JpaRepository<MovimentoCaixa, BigDecimal> {

    @Query("""
        SELECT new br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecQueryResumo(
            mc.movimento,
            mc.entrada,
            mc.saida,
            mc.complemento,
            h.historico,
            hc.descreve,
            cc.descreve,
            sc.descricao
        )
        FROM MovimentoCaixa mc
        LEFT JOIN HistoricosCaixa h ON mc.historico = h.codHistorico
        LEFT JOIN HistoricosCaixaContrapartida hc ON hc.codContrapartida = mc.contrapartida
        LEFT JOIN ContasCaixa cc ON cc.codCaixa = mc.caixa
        LEFT JOIN SubContas sc ON sc.codInterno = mc.centroResultados
        WHERE
            mc.eliminado = false
            AND mc.empresa = 1
            AND mc.movimento BETWEEN :inicio AND :fim
        ORDER BY movimento DESC
    """)
    List<RecQueryResumo> listarMovimentacoes(
            @Param("inicio") LocalDateTime inicio,
            @Param("fim") LocalDateTime fim
    );
}
