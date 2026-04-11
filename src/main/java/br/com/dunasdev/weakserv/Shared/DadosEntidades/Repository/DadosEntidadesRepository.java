package br.com.dunasdev.weakserv.Shared.DadosEntidades.Repository;

import br.com.dunasdev.weakserv.Shared.DadosEntidades.Models.DadosEntidades;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DadosEntidadesRepository extends JpaRepository<DadosEntidades, Integer> {

    Optional<DadosEntidades> findByCodEntidade(Integer codEntidade);

}
