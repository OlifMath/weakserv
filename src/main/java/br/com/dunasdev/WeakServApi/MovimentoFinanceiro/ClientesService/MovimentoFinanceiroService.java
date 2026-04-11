package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.ClientesService;

import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Repository.MovimentoFinanceiroRepository;

public class MovimentoFinanceiroService {

    private final MovimentoFinanceiroRepository movRepository;

    public MovimentoFinanceiroService(MovimentoFinanceiroRepository movRepository) {
        this.movRepository = movRepository;
    }
}
