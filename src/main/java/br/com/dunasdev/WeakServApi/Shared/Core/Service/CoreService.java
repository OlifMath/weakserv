package br.com.dunasdev.WeakServApi.Shared.Core.Service;

import org.springframework.stereotype.Service;
import br.com.dunasdev.WeakServApi.Shared.Core.Repository.CoreRepository;

@Service
public class CoreService {

    //region Atributos
    private static CoreRepository coreRepository;
    //endregion

    //region Construtores
    public CoreService(CoreRepository coreRepository) {
        CoreService.coreRepository = coreRepository;
    }
    //endregion

    //region Métodos

    //region Busca Planilha
    public static Long buscaPlanilha() {
        if (coreRepository == null) {
            throw new IllegalStateException("O Spring ainda não inicializou o repositório!");
        }

        return coreRepository.addPlanilha();
    }
    //endregion

    //endregion

}