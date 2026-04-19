package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Repository;

import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Models.HistoricosCaixaContrapartida;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HistoricosCaixaContrapartidaRepository extends JpaRepository<HistoricosCaixaContrapartida, BigDecimal> {

    @Query("""
        SELECT c FROM HistoricosCaixaContrapartida c
        WHERE c.caixa = :caixa
          AND LOWER(c.entSai) = LOWER(:entSai)
          AND c.cheque = false
    """)
    Optional<HistoricosCaixaContrapartida> buscarContrapartida(
            @Param("caixa") BigDecimal caixa,
            @Param("entSai") String entSai
    );
}
