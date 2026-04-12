package br.com.dunasdev.WeakServApi.Clientes.Controllers;

import br.com.dunasdev.WeakServApi.Clientes.Services.ClientesService;
import br.com.dunasdev.WeakServApi.Clientes.Records.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    private final ClientesService cliService;

    public ClientesController(ClientesService cliService) {
        this.cliService = cliService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<RecordResponse> cadastrar(@RequestBody RecordRequest novoCliente) {
        var ClienteCriado = cliService.criarCadastro(novoCliente.nome());
        return ResponseEntity.ok(ClienteCriado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<RecordResponse>> listar() {
        var listaClientes = cliService.listarClientes();
        return ResponseEntity.ok(listaClientes);
    }
}