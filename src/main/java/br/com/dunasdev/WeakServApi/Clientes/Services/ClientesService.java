package br.com.dunasdev.WeakServApi.Clientes.Services;

import br.com.dunasdev.WeakServApi.Clientes.Records.RecResponse;
import br.com.dunasdev.WeakServApi.Clientes.Models.Clientes;
import br.com.dunasdev.WeakServApi.Clientes.Repository.ClientesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientesService {

    private final ClientesRepository cliRepository;
    private final ClientesServiceHelper helper;

    public ClientesService(ClientesRepository cliRepository, ClientesServiceHelper helper) {
        this.cliRepository = cliRepository;
        this.helper = helper;
    }

    @Transactional
    public RecResponse criarCadastro(String nome) {
        var novoCliente = new Clientes();

        BeanUtils.copyProperties(helper.obterClienteModelo(), novoCliente, "codCliente");

        novoCliente.setCodCliente(helper.obterNovoCodCliente());
        novoCliente.setNome(nome);
        cliRepository.save(novoCliente);

        return RecResponse.from(novoCliente);
    }

    public List<RecResponse> listarClientes(){
        return RecResponse.from(cliRepository.findAll());
    }
}
