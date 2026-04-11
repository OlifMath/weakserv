package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Repository;

import br.com.dunasdev.WeakServApi.Clientes.Models.Clientes;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Models.MovimentoCaixa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovimentoFinanceiroRepository extends JpaRepository<MovimentoCaixa, Integer> {

}
