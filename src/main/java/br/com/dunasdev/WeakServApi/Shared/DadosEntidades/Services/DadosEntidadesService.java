package br.com.dunasdev.WeakServApi.Shared.DadosEntidades.Services;

import br.com.dunasdev.WeakServApi.Shared.DadosEntidades.Models.DadosEntidades;
import br.com.dunasdev.WeakServApi.Shared.DadosEntidades.Repository.DadosEntidadesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;
import java.util.function.Function;

@Service
public class DadosEntidadesService {

    private final DadosEntidadesRepository entRepository;

    public DadosEntidadesService(DadosEntidadesRepository entRepository) {
        this.entRepository = entRepository;
    }

    public <TipoRetorno> TipoRetorno obterValor(int codEntidade, Function<DadosEntidades, TipoRetorno> campo) {
        return entRepository.findByCodEntidade(codEntidade)
                .map(campo)
                .orElseThrow(() -> new RuntimeException("Configuração para entidade cód: " + codEntidade + " não foi encontrada."));
    }

    @Transactional
    public <ValorTipo> void salvarValor(int codEntidade, BiConsumer<DadosEntidades, ValorTipo> campo, ValorTipo valor) {
        var entidade = entRepository.findByCodEntidade(codEntidade)
                .orElseThrow(() -> new RuntimeException("Configuração para entidade cód: " + codEntidade + " não foi encontrada."));

        campo.accept(entidade, valor);
        entRepository.save(entidade);
    }
}