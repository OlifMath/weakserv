package br.com.dunasdev.WeakServApi.Shared.Tabelas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SubContas")
public class SubContas {

    @Id
    @Column(name = "CodInterno", nullable = false, precision = 18, scale = 0)
    private BigDecimal codInterno;

    @Column(name = "Descrição", nullable = false, length = 50)
    private String descricao;

    @Column(name = "CentroResultados", nullable = false, precision = 18, scale = 0)
    private BigDecimal centroResultados;

    @Column(name = "Veiculos")
    private Boolean veiculos;

    @Column(name = "DespVeículos", precision = 18, scale = 0)
    private BigDecimal despVeiculos;

    @Column(name = "Detalhada", nullable = false)
    private Boolean detalhada;

    @Column(name = "ContaExportacao", length = 100)
    private String contaExportacao;

    @Column(name = "Inativo")
    private Boolean inativo;

    @Column(name = "CentroVinculado", nullable = false, precision = 18, scale = 0)
    private BigDecimal centroVinculado;

    @Column(name = "SomaBI", nullable = false)
    private Boolean somaBI;
}