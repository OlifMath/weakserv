package br.com.dunasdev.WeakServApi.Shared.Core.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CoreRepository {

    //region Atributos
    private final EntityManager entityManager;
    //endregion

    //region Construtores
    public CoreRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //endregion

    //region Métodos

    //region Busca Planilha
    @Transactional
    public Long addPlanilha() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("fn_AddPlanilha");

        query.registerStoredProcedureParameter("pla", Long.class, ParameterMode.OUT);
        query.execute();
        Long resultado = (Long) query.getOutputParameterValue("pla");

        return resultado != null ? resultado : 0L;
    }
    //endregion

    //endregion

}