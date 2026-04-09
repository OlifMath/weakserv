package br.com.dunasdev.weakserv.Clientes;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

    Optional<Clientes> findByCodCliente(Integer CodCliente);

}