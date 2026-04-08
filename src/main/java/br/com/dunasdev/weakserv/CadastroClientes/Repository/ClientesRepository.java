package br.com.dunasdev.weakserv.CadastroClientes.Repository;

import br.com.dunasdev.weakserv.CadastroClientes.Model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}