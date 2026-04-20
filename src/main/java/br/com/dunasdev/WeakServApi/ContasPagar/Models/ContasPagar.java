package br.com.dunasdev.WeakServApi.ContasPagar.Models;

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
@Table(name = "ContasPagar")
public class ContasPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodInterno", nullable = false, precision = 18, scale = 0)
    private BigDecimal codInterno;

    @Column(name = "Empresa", length = 8)
    private String empresa;

    @Column(name = "Operação", length = 20)
    private String operacao;

    @Column(name = "Fornecedor", precision = 18, scale = 0)
    private BigDecimal fornecedor;

    @Column(name = "NotaFiscal", precision = 18, scale = 0)
    private BigDecimal notaFiscal;

    @Column(name = "Série", length = 20)
    private String serie;

    @Column(name = "DataEmissão")
    private LocalDateTime dataEmissao;

    @Column(name = "FormaPagamento", precision = 18, scale = 0)
    private BigDecimal formaPagamento;

    @Column(name = "Pago")
    private Boolean pago;

    @Column(name = "Número", length = 100)
    private String numero;

    @Column(name = "Letra", length = 100)
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

    @Column(name = "CentroResultados", precision = 18, scale = 0)
    private BigDecimal centroResultados;

    @Column(name = "AcrescimosFinanceiros", precision = 19, scale = 4)
    private BigDecimal acrescimosFinanceiros;

    @Column(name = "Liberado")
    private Boolean liberado;

    @Column(name = "DataLiberação")
    private LocalDateTime dataLiberacao;

    @Column(name = "UsuárioLiberação", length = 100)
    private String usuarioLiberacao;

    @Column(name = "LiberadoHolding")
    private Boolean liberadoHolding;

    @Column(name = "Confirmado")
    private Boolean confirmado;

    @Column(name = "Favorecido", length = 100)
    private String favorecido;

    @Column(name = "JurosDuplicata", precision = 19, scale = 4)
    private BigDecimal jurosDuplicata;

    @Column(name = "SelePla", precision = 18, scale = 0)
    private BigDecimal selePla;

    @Lob
    @Column(name = "EventosDuplicata")
    private String eventosDuplicata;

    @Column(name = "Remessa")
    private Boolean remessa;

    @Column(name = "ContaVinculada", precision = 18, scale = 0)
    private BigDecimal contaVinculada;

    @Column(name = "VencimentoOriginal")
    private LocalDateTime vencimentoOriginal;

    @Column(name = "Beneficiário", length = 400)
    private String beneficiario;

    @Column(name = "CNPJBeneficiário", length = 100)
    private String cnpjBeneficiario;

    @Column(name = "DataLancamento", nullable = false)
    private LocalDateTime dataLancamento;

    @Column(name = "LiberaStatus", length = 2)
    private String liberaStatus;

    @Lob
    @Column(name = "Observações")
    private String observacoes;

    @Lob
    @Column(name = "Observações2")
    private String observacoes2;
}
