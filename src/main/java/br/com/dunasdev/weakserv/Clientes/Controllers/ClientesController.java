package br.com.dunasdev.weakserv.Clientes.Controllers;

import br.com.dunasdev.weakserv.Clientes.Models.Clientes;
import br.com.dunasdev.weakserv.Clientes.ClientesService.ClientesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.dunasdev.weakserv.Clientes.Records.ClientesRecord.*;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    private final ClientesService cliService;

    public ClientesController(ClientesService cliService) {
        this.cliService = cliService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Clientes> cadastrar(@RequestBody NovoCliente novoCliente) {
        Clientes clienteCadastrado = cliService.criarCadastro(novoCliente.nome());
        return ResponseEntity.ok(clienteCadastrado);
    }
}