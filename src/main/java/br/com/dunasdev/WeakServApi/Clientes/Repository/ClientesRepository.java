package br.com.dunasdev.WeakServApi.Clientes.Repository;

import br.com.dunasdev.WeakServApi.Clientes.Models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

    Optional<Clientes> findByCodCliente(BigDecimal codCliente);

    @Query("""
    SELECT c FROM Clientes c
    WHERE (
          (:codCliente IS NOT NULL AND c.codCliente = :codCliente)
          OR (:buscaTexto IS NOT NULL AND CAST(c.codCliente AS String) LIKE CONCAT('%', :buscaTexto, '%'))
          OR (:buscaTexto IS NOT NULL AND LOWER(c.nome) LIKE LOWER(CONCAT('%', :buscaTexto, '%')))
          OR (:buscaCpfCnpj IS NOT NULL AND REPLACE(REPLACE(REPLACE(c.CGCCPF, '.', ''), '-', ''), '/', '') LIKE CONCAT('%', :buscaCpfCnpj, '%'))
      )
    ORDER BY c.nome ASC
    """)
    List<Clientes> listarClientes(
            @Param("codCliente") Integer codCliente,
            @Param("buscaTexto") String buscaTexto,
            @Param("buscaCpfCnpj") String buscaCpfCnpj
    );
}