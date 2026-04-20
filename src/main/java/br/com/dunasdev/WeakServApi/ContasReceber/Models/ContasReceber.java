package br.com.dunasdev.WeakServApi.ContasReceber.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@Table(name = "ContasReceber")
public class ContasReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodInterno", nullable = false, precision = 18, scale = 0)
    private BigDecimal codInterno;

    @Column(name = "Empresa", length = 8)
    private String empresa;

    @Column(name = "Operação", length = 30)
    private String operacao;

    @Column(name = "Cliente", precision = 18, scale = 0)
    private BigDecimal cliente;

    @Column(name = "NotaFiscal", length = 20)
    private String notaFiscal;

    @Column(name = "Série", length = 20)
    private String serie;

    @Column(name = "DataEmissão")
    private LocalDateTime dataEmissao;

    @Column(name = "FormaPagamento", precision = 18, scale = 0)
    private BigDecimal formaPagamento;

    @Column(name = "Pago")
    private Boolean pago;

    @Column(name = "Número", length = 20)
    private String numero;

    @Column(name = "Letra", length = 4)
    private String letra;

    @Column(name = "Vencimento")
    private LocalDateTime vencimento;

    @Column(name = "ValorDuplicata", precision = 19, scale = 4)
    private BigDecimal valorDuplicata;

    @Column(name = "DataPagamento")
    private LocalDateTime dataPagamento;

    @Column(name = "Credito", precision = 19, scale = 4)
    private BigDecimal credito;

    @Column(name = "Debito", precision = 19, scale = 4)
    private BigDecimal debito;

    @Column(name = "Saldo", precision = 19, scale = 4)
    private BigDecimal saldo;

    @Column(name = "Planílha", precision = 18, scale = 0)
    private BigDecimal planilha;

    @Column(name = "Usuário", length = 100)
    private String usuario;

    @Column(name = "Impresso")
    private Boolean impresso;

    @Column(name = "Agrupada")
    private Boolean agrupada;

    @Column(name = "Selecionada")
    private Boolean selecionada;

    @Column(name = "BloquetoImpresso")
    private Boolean bloquetoImpresso;

    @Column(name = "CentroResultados", precision = 18, scale = 0)
    private BigDecimal centroResultados;

    @Column(name = "Remessa")
    private Boolean remessa;

    @Column(name = "AcrescimosFinanceiros", precision = 19, scale = 4)
    private BigDecimal acrescimosFinanceiros;

    @Column(name = "VencimentoOriginal")
    private LocalDateTime vencimentoOriginal;

    @Lob
    @Column(name = "EventosDuplicata")
    private String eventosDuplicata;

    @Lob
    @Column(name = "Observacoes")
    private String observacoes;
}
