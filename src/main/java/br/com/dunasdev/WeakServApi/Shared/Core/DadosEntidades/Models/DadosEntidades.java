package br.com.dunasdev.WeakServApi.Shared.Core.DadosEntidades.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DadosEntidades")
public class DadosEntidades {

    @Id
    @Column(name = "CodInterno")
    private Integer codInterno;

    @Column(name = "CodEntidade")
    private Integer codEntidade;

    @Column(name = "Codigo")
    private String codigo;

    @Column(name = "Descreve")
    private String descreve;

    @Column(name = "Unidade")
    private java.math.BigDecimal unidade;

    @Column(name = "Empresa")
    private java.math.BigDecimal empresa;

    @Column(name = "Detalhes")
    private String detalhes;

    @Column(name = "Inativa")
    private Boolean inativa;

    @Column(name = "SSXIDMapIcon")
    private java.math.BigDecimal sSXIDMapIcon;

    @Column(name = "SSXIDMapIconColor")
    private java.math.BigDecimal sSXIDMapIconColor;

    @Column(name = "SSXIgnitionStatus")
    private Boolean sSXIgnitionStatus;

    @Column(name = "SSXOperationalStatus")
    private Boolean sSXOperationalStatus;

    @Column(name = "SSXGPSStatus")
    private Boolean sSXGPSStatus;

    @Column(name = "SSXWarningStatus")
    private Boolean sSXWarningStatus;

}
