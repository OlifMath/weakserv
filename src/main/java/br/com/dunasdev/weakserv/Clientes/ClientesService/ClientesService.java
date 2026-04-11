package br.com.dunasdev.weakserv.Clientes.ClientesService;

import br.com.dunasdev.weakserv.Clientes.Repository.ClientesRepository;
import br.com.dunasdev.weakserv.Clientes.Models.Clientes;
import br.com.dunasdev.weakserv.Shared.DadosEntidades.Repository.DadosEntidadesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientesService {

    private final ClientesRepository cliRepository;
    private final DadosEntidadesRepository entRepository;

    public ClientesService(ClientesRepository cliRepository, DadosEntidadesRepository entRepository) {
        this.cliRepository = cliRepository;
        this.entRepository = entRepository;
    }

    @Transactional
    public Clientes criarCadastro(String nome) {
        var novoCliente = new Clientes();

        BeanUtils.copyProperties(obterClienteModelo(), novoCliente, "codCliente");

        novoCliente.setCodCliente(obterNovoCodCliente());
        novoCliente.setNome(nome);
        cliRepository.save(novoCliente);

        return novoCliente;
    }

    private Clientes obterClienteModelo() {
        final int codEntidadeModelo = 34;

        var codClienteModeloStr = entRepository.findByCodEntidade(codEntidadeModelo)
                                            .orElseThrow(() -> new RuntimeException("Configuração para cliente modelo (entidade cód: " + codEntidadeModelo + ") não foi encontrada."))
                                            .getCodigo();
        
        var codClienteModelo = Integer.parseInt(codClienteModeloStr);

        return cliRepository.findByCodCliente(codClienteModelo)
                            .orElseThrow(() -> new RuntimeException("O cliente modelo (código: " + codClienteModelo + ") não foi encontrado no banco de dados. Verifique o cadastro de clientes."));
    }

    @Transactional
    private Integer obterNovoCodCliente() {
        final int codEntidadeNovoCliente = 11;

        var entidade = entRepository.findByCodEntidade(codEntidadeNovoCliente)
                                        .orElseThrow(() -> new RuntimeException("Configuração para novo código de cliente (entidade cód: " + codEntidadeNovoCliente + ") não foi encontrada."));

        var proximoCodigo = Integer.valueOf(entidade.getCodigo());

        while (cliRepository.findByCodCliente(proximoCodigo).isPresent()) {
            proximoCodigo++;
        }

        entidade.setCodigo(String.valueOf(proximoCodigo + 1));
        entRepository.save(entidade);

        return proximoCodigo;
    }
}
