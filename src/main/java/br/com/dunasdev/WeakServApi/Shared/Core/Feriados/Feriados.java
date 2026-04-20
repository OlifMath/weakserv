package br.com.dunasdev.WeakServApi.Shared.Core.Feriados;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Feriados")
public class Feriados {

    @Id
    @Column(name = "CodInterno", precision = 18, scale = 0)
    private BigDecimal codInterno;

    @Column(name = "Data")
    private LocalDate data;

    @Column(name = "Descrição", length = 200)
    private String descricao;
}
