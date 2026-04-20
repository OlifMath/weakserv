package br.com.dunasdev.WeakServApi.Clientes.Services;

import br.com.dunasdev.WeakServApi.Clientes.Models.Clientes;
import br.com.dunasdev.WeakServApi.Clientes.Repository.ClientesRepository;
import br.com.dunasdev.WeakServApi.Shared.Core.DadosEntidades.Models.DadosEntidades;
import br.com.dunasdev.WeakServApi.Shared.Core.DadosEntidades.Repository.DadosEntidadesRepository;
import br.com.dunasdev.WeakServApi.Shared.Core.DadosEntidades.Services.DadosEntidadesService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
class ClientesServiceHelper {

    private final Integer codEntidadeModelo = 34;;
    private final Integer codEntidadeNovoCliente = 11;

    private final ClientesRepository cliRepository;
    private final DadosEntidadesRepository entRepository;
    private final DadosEntidadesService entService;

    protected ClientesServiceHelper(ClientesRepository cliRepository, DadosEntidadesRepository entRepository, DadosEntidadesService entService) {
        this.cliRepository = cliRepository;
        this.entRepository = entRepository;
        this.entService = entService;
    }

    @Transactional
    protected Integer obterNovoCodCliente() {

        var proximoCodCliente = entService.obterValor(codEntidadeNovoCliente, entidade -> Integer.parseInt(entidade.getCodigo()));

        while (cliRepository.findByCodCliente(proximoCodCliente).isPresent()) {
            proximoCodCliente++;
        }

        entService.salvarValor(codEntidadeNovoCliente, DadosEntidades::setCodigo, String.valueOf(proximoCodCliente + 1));

        return proximoCodCliente;
    }

    protected Clientes obterClienteModelo() {

        var codClienteModelo = Integer.parseInt(
                entService.obterValor(codEntidadeModelo, entidade -> entidade.getCodigo())
        );

        return cliRepository.findByCodCliente(codClienteModelo)
                .orElseThrow(() -> new RuntimeException(
                        "Cliente modelo (código: " + codClienteModelo + ") não encontrado."));
    }
}