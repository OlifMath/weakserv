package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Service;

import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Models.MovimentoCaixa;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Repository.MovimentoFinanceiroRepository;

import java.util.List;

public class MovimentoFinanceiroService {

    private final MovimentoFinanceiroRepository movRepository;

    public MovimentoFinanceiroService(MovimentoFinanceiroRepository movRepository) {
        this.movRepository = movRepository;
    }

    public List<MovimentoCaixa> listarTodos() {
        return movRepository.findAll();
    }
}
