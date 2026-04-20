package br.com.dunasdev.WeakServApi.Shared.Utils;

import br.com.dunasdev.WeakServApi.Shared.Core.Feriados.FeriadosRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DataUtils {

    //region Ajusta Vencimento
    public static LocalDate ajustaVencimento(LocalDate data, FeriadosRepository feriadosRepository) {
        LocalDate ajustada = data;

        while (true) {
            DayOfWeek diaSemana = ajustada.getDayOfWeek();

            if (diaSemana == DayOfWeek.SATURDAY) {
                ajustada = ajustada.plusDays(2);
                continue;
            }

            if (diaSemana == DayOfWeek.SUNDAY) {
                ajustada = ajustada.plusDays(1);
                continue;
            }

            if (feriadosRepository.existsByData(ajustada)) {
                ajustada = ajustada.plusDays(1);
                continue;
            }

            break;
        }

        return ajustada;
    }
    //endregion

    //region Gera Letra por Índice
    public static String geraLetra(int indice) {
        if (indice < 26) {
            return String.valueOf((char) ('A' + indice));
        }
        return String.valueOf((char) ('A' + (indice % 26))) + (indice / 26);
    }
    //endregion
}
