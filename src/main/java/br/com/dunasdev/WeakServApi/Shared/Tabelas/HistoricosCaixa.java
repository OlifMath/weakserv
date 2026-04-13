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
@Table(name = "HistóricosCaixa")
public class HistoricosCaixa {

    @Id
    @Column(name = "CodHistórico", nullable = false, precision = 18, scale = 0)
    private BigDecimal codHistorico;

    @Column(name = "Histórico", length = 400)
    private String historico;

    @Column(name = "EntSai", length = 1)
    private String entSai;

    @Column(name = "Recibo")
    private Boolean recibo;

    @Column(name = "Duplicata")
    private Boolean duplicata;

    @Column(name = "Comissão")
    private Boolean comissao;

    @Column(name = "CentroResultados", precision = 18, scale = 0)
    private BigDecimal centroResultados;

    @Column(name = "Adiantamento", length = 1)
    private String adiantamento;

    @Column(name = "Cheque", length = 1)
    private String cheque;

    @Column(name = "DescontoDuplicata")
    private Boolean descontoDuplicata;

    @Column(name = "EmiteBorderô")
    private Boolean emiteBordero;

    @Column(name = "MovimentaAplicação")
    private Boolean movimentaAplicacao;

    @Column(name = "Inativo")
    private Boolean inativo;

    @Column(name = "GeraCompetência")
    private Boolean geraCompetencia;

    @Column(name = "ContaExportação", length = 100)
    private String contaExportacao;

    @Column(name = "TransferenciaCaixa")
    private Boolean transferenciaCaixa;

    @Column(name = "Gera1601")
    private Boolean gera1601;
}