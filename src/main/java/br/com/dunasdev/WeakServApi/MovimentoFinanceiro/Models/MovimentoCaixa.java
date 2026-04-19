package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@Table(name = "MovimentoCaixa")
public class MovimentoCaixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodInterno", nullable = false, precision = 18, scale = 0)
    private BigDecimal codInterno;

    @Column(name = "Planílha", precision = 18, scale = 0)
    private BigDecimal planilha;

    @Column(name = "Movimento")
    private LocalDateTime movimento;

    @Column(name = "Usuário", length = 100)
    private String usuario;

    @Column(name = "Entrada", precision = 19, scale = 4)
    private BigDecimal entrada = BigDecimal.ZERO;

    @Column(name = "Saída", precision = 19, scale = 4)
    private BigDecimal saida = BigDecimal.ZERO;

    @Column(name = "Histórico", precision = 18, scale = 0)
    private BigDecimal historico;

    @Column(name = "Contrapartida", precision = 18, scale = 0)
    private BigDecimal contrapartida;

    @Column(name = "Complemento", length = 500)
    private String complemento;

    @Column(name = "Eliminado")
    private Boolean eliminado = false;

    @Column(name = "EliminadoPor", length = 100)
    private String eliminadoPor;

    @Column(name = "Motivo", length = 100)
    private String motivo;

    @Column(name = "Empresa")
    private Integer empresa;

    @Column(name = "Caixa", precision = 18, scale = 0)
    private BigDecimal caixa;

    @Column(name = "Compensado")
    private Boolean compensado = true;

    @Column(name = "CentroResultados", precision = 18, scale = 0)
    private BigDecimal centroResultados;

    @Column(name = "Origem", length = 4)
    private String origem;

    @Column(name = "DRE")
    private Boolean dRE = true;

    @Column(name = "Competência")
    private LocalDateTime competencia = LocalDateTime.now();

    @Column(name = "Borderô", precision = 18, scale = 0)
    private BigDecimal bordero;

    @Column(name = "DataEliminação")
    private LocalDateTime dataEliminacao;

    @Column(name = "DataApresentaçãoCheque")
    private LocalDateTime dataApresentacaoCheque = LocalDateTime.now();

    @Column(name = "ChequeEmitido", length = 20)
    private String chequeEmitido;

    @Column(name = "CodRetorno", precision = 18, scale = 0)
    private BigDecimal codRetorno;

    @Column(name = "DataHoraServer")
    private LocalDateTime dataHoraServer;

    @Column(name = "DataCompensação")
    private LocalDateTime dataCompensacao;

    @Lob
    @Column(name = "LogAlterações")
    private String logAlteracoes;

    @Column(name = "Conciliado")
    private Boolean conciliado;

    @Column(name = "CodFatLote", precision = 18, scale = 0)
    private BigDecimal codFatLote;

    @Column(name = "PlaVinculoOFX", precision = 18, scale = 0)
    private BigDecimal plaVinculoOFX;

    @Column(name = "IDTransPJ", length = 400)
    private String iDTransPJ;

    @Column(name = "TransPJStatus", length = 40)
    private String transPJStatus;
}