package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Repository;

import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Models.MovimentoCaixa;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecResumoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovimentoFinanceiroRepository extends JpaRepository<MovimentoCaixa, BigDecimal> {

    @Query("""
        SELECT new br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecResumoTransacao(
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
    List<RecResumoTransacao> listarTransacoes(
            @Param("inicio") LocalDateTime inicio,
            @Param("fim") LocalDateTime fim
    );

    @Query("""
        SELECT new br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecResumoTransacao(
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
            mc.codInterno = :id
    """)
    RecResumoTransacao buscarTransacaoById(
            @Param("id") BigDecimal id
    );
}
