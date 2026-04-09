package br.com.dunasdev.weakserv.Clientes;

import br.com.dunasdev.weakserv.Shared.DadosEntidades.DadosEntidadesRepository;
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

        BeanUtils.copyProperties(obterClienteModelo(), novoCliente);

        novoCliente.setCodCliente(obterNovoCodCliente());
        novoCliente.setNome(nome);

        return cliRepository.save(novoCliente);
    }

    private Clientes obterClienteModelo() {
        //CodEntidade chumbado no código mesmo. Não grita!
        var codClienteModelo = entRepository.findByCodEntidade(34)
                                            .orElseThrow(() -> new RuntimeException("Entidade não encontrada"))
                                            .getCodigo();
        var clienteModelo = cliRepository.findByCodCliente(Integer.parseInt(codClienteModelo));

        return clienteModelo.get();
    }

    @Transactional
    private Integer obterNovoCodCliente() {
        var entidade = entRepository.findByCodEntidade(11)
                                        .orElseThrow(() -> new RuntimeException("Entidade não encontrada"));

        var novoCodigo = Integer.valueOf(entidade.getCodigo());

        do {
            if(cliRepository.findByCodCliente(novoCodigo).isEmpty()) {
                entidade.setCodigo(String.valueOf(novoCodigo));
                entRepository.save(entidade);
                break;
            }
            else{
                novoCodigo++;
            }
        } while(true);

        return novoCodigo;
    }
}