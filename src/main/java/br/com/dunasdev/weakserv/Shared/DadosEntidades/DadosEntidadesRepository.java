package br.com.dunasdev.weakserv.Shared.DadosEntidades;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DadosEntidadesRepository extends JpaRepository<DadosEntidades, Long> {

    Optional<DadosEntidades> findByCodEntidade(Integer codEntidade);

}
