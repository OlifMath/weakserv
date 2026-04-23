package br.com.dunasdev.WeakServApi.Shared.Core.BuscaPlanilha.Service;

import org.springframework.stereotype.Service;
import br.com.dunasdev.WeakServApi.Shared.Core.BuscaPlanilha.Repository.BuscaPlanilhaRepository;

import java.math.BigDecimal;

@Service
public class BuscaPlanilhaService {

    //region Atributos
    private static BuscaPlanilhaRepository buscaPlanilhaRepository;
    //endregion

    //region Construtores
    public BuscaPlanilhaService(BuscaPlanilhaRepository buscaPlanilhaRepository) {
        BuscaPlanilhaService.buscaPlanilhaRepository = buscaPlanilhaRepository;
    }
    //endregion

    //region Métodos

    //region Busca Planilha
    public static BigDecimal buscaPlanilha() {
        if (buscaPlanilhaRepository == null) {
            throw new IllegalStateException("O Spring ainda não inicializou o repositório!");
        }

        return buscaPlanilhaRepository.addPlanilha();
    }
    //endregion

    //endregion

}