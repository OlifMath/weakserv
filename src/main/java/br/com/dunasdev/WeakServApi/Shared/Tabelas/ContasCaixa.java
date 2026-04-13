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
@Table(name = "ContasCaixa")
public class ContasCaixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodCaixa", nullable = false, precision = 18, scale = 0)
    private BigDecimal codCaixa;

    @Column(name = "Descreve", nullable = false, length = 50)
    private String descreve;

    @Column(name = "ContaCorrente")
    private Boolean contaCorrente;

    @Column(name = "CodBanco", length = 3)
    private String codBanco;

    @Column(name = "Agencia", precision = 18, scale = 0)
    private BigDecimal agencia;

    @Column(name = "Conta", precision = 18, scale = 0)
    private BigDecimal conta;

    @Column(name = "Titular", length = 50)
    private String titular;

    @Column(name = "Aplicação")
    private Boolean aplicacao;

    @Column(name = "Unidade", precision = 18, scale = 0)
    private BigDecimal unidade;

    @Column(name = "SérieCheque", length = 6)
    private String serieCheque;

    @Column(name = "TempoCompensação", precision = 18, scale = 0)
    private BigDecimal tempoCompensacao;

    @Column(name = "ContaExportacao", length = 100)
    private String contaExportacao;

    @Column(name = "Inativo")
    private Boolean inativo;

    @Column(name = "EmpresasLiberadas", length = 8000)
    private String empresasLiberadas;

    @Column(name = "FiltroExibeCaixa")
    private Integer filtroExibeCaixa;

    @Column(name = "LimiteChequeEspecial", precision = 19, scale = 4)
    private BigDecimal limiteChequeEspecial;

    @Column(name = "Gera1601")
    private Boolean gera1601;

    @Column(name = "Cliente1601", precision = 18, scale = 0)
    private BigDecimal cliente1601;

    @Column(name = "Credencial", length = 510)
    private String credencial;

    @Column(name = "Chave", length = 510)
    private String chave;
}