package br.com.dunasdev.weakserv.Clientes.Repository;

import br.com.dunasdev.weakserv.Clientes.Models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

    Optional<Clientes> findByCodCliente(Integer CodCliente);

}