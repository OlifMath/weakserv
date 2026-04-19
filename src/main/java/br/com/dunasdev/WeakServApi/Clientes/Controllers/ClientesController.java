package br.com.dunasdev.WeakServApi.Clientes.Controllers;

import br.com.dunasdev.WeakServApi.Clientes.Services.ClientesService;
import br.com.dunasdev.WeakServApi.Clientes.Records.*;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<RecResponse> cadastrar(@RequestBody RecRequest novoCliente) {
        var ClienteCriado = cliService.criarCadastro(novoCliente.nome());
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteCriado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<RecResponse>> listar(@RequestParam(required = false) String filtro) {
        var listaClientes = cliService.listarClientes(filtro);
        return ResponseEntity.ok(listaClientes);
    }
}