package br.com.dunasdev.weakserv.Clientes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.dunasdev.weakserv.Clientes.ClientesRecord.*;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    private final ClientesService cliService;

    public ClientesController(ClientesService cliService) {
        this.cliService = cliService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Clientes> cadastrar(@RequestBody String novoCliente) {
        Clientes clienteCadastrado = cliService.criarCadastro(novoCliente);
        return ResponseEntity.ok(clienteCadastrado);
    }
}