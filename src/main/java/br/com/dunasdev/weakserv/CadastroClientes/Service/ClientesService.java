package br.com.dunasdev.weakserv.CadastroClientes.Service;

import br.com.dunasdev.weakserv.CadastroClientes.Model.Clientes;
import br.com.dunasdev.weakserv.CadastroClientes.Repository.ClientesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientesService {

    private final ClientesRepository repository;

    public ClientesService(ClientesRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Clientes criarCadastro(String nome) {
        Clientes modelo = obterModeloFixo();
        Clientes novaPessoa = new Clientes();

        BeanUtils.copyProperties(modelo, novaPessoa);

        novaPessoa.setCodCliente(codCliente);
        novaPessoa.setNome(nome);

        return repository.save(novaPessoa);
    }

    private Clientes obterModeloFixo() {

        return modelo;
    }

    private Integer obterUltimoCodCliente() {



        return codCliente;
    }
}