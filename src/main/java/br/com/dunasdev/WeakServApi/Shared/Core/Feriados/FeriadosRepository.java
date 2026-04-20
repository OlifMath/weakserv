package br.com.dunasdev.WeakServApi.Shared.Core.Feriados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface FeriadosRepository extends JpaRepository<Feriados, BigDecimal> {

    boolean existsByData(LocalDate data);
}
