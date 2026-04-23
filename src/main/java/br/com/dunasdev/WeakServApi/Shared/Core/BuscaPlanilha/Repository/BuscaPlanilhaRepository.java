package br.com.dunasdev.WeakServApi.Shared.Core.BuscaPlanilha.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

@Repository
public class BuscaPlanilhaRepository {

    //region Atributos
    private final EntityManager entityManager;
    //endregion

    //region Construtores
    public BuscaPlanilhaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //endregion

    //region Métodos

    //region Busca Planilha
    @Transactional
    public BigDecimal addPlanilha() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("fn_AddPlanilha");

        query.registerStoredProcedureParameter("pla", BigDecimal.class, ParameterMode.OUT);
        query.execute();
        var resultado = (BigDecimal) query.getOutputParameterValue("pla");

        return resultado != null ? resultado : BigDecimal.ZERO;
    }
    //endregion

    //endregion

}