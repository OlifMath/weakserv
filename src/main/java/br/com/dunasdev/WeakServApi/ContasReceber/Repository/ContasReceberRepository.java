package br.com.dunasdev.WeakServApi.ContasReceber.Repository;

import br.com.dunasdev.WeakServApi.ContasReceber.Models.ContasReceber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ContasReceberRepository extends JpaRepository<ContasReceber, BigDecimal> {

    @Query(value = "SELECT COALESCE(MAX(CAST([Número] AS BIGINT)), 0) FROM ContasReceber", nativeQuery = true)
    Long buscarMaxNumero();

    Optional<ContasReceber> findByCodInterno(BigDecimal codInterno);
}
