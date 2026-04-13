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
        LEFT JOIN HistóricosCaixa h ON mc.Histórico = h.codHistórico
        LEFT JOIN HistóricosCaixaContrapartida hc ON hc.codContrapartida = mc.Contrapartida
        LEFT JOIN ContasCaixa cc ON cc.codCaixa = mc.Caixa
        LEFT JOIN SubContas sc ON sc.codInterno = mc.CentroResultados
        WHERE
            mc.eliminado = false
            AND mc.empresa = 1
            AND mc.movimento BETWEEN :inicio AND :final
        ORDER BY movimento DESC
    """)
    List<RecQueryResumo> listarMovimentacoes(
            @Param("inicio") LocalDateTime inicio,
            @Param("final") LocalDateTime fim
    );
}
