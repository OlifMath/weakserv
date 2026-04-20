package br.com.dunasdev.WeakServApi.ContasPagar.Repository;

import br.com.dunasdev.WeakServApi.ContasPagar.Models.ContasPagar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ContasPagarRepository extends JpaRepository<ContasPagar, BigDecimal> {

    @Query(value = "SELECT COALESCE(MAX(CAST([Número] AS BIGINT)), 0) FROM ContasPagar", nativeQuery = true)
    Long buscarMaxNumero();

    Optional<ContasPagar> findByCodInterno(BigDecimal codInterno);
}
