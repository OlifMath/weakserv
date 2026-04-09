package br.com.dunasdev.weakserv.Clientes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    private final ClientesService service;

    public ClientesController(ClientesService service) {
        this.service = service;
    }

    public record NovoCliente(String nome) {}

    @PostMapping("/cadastrar")
    public ResponseEntity<Clientes> cadastrar(@RequestBody NovoCliente novoCliente) {
        Clientes clienteCadastrado = service.criarCadastro(novoCliente.nome());
        return ResponseEntity.ok(clienteCadastrado);
    }
}