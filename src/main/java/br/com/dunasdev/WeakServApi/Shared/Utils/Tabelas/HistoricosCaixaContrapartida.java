package br.com.dunasdev.WeakServApi.Shared.Utils.Tabelas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HistóricosCaixaContrapartida")
public class HistoricosCaixaContrapartida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodContrapartida", nullable = false, precision = 18, scale = 0)
    private BigDecimal codContrapartida;

    @Column(name = "Descreve", length = 400)
    private String descreve;

    @Column(name = "EntSai", length = 1)
    private String entSai;

    @Column(name = "Cheque")
    private Boolean cheque;

    @Column(name = "Caixa", precision = 18, scale = 0)
    private BigDecimal caixa;
}