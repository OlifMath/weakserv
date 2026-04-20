package br.com.dunasdev.WeakServApi.ContasPagar.Controllers;

import br.com.dunasdev.WeakServApi.ContasPagar.Records.RecLancaContasPagar;
import br.com.dunasdev.WeakServApi.ContasPagar.Records.RecResumoContasPagar;
import br.com.dunasdev.WeakServApi.ContasPagar.Services.ContasPagarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contas-pagar")
public class ContasPagarController {

    private final ContasPagarService contasPagarService;

    public ContasPagarController(ContasPagarService contasPagarService) {
        this.contasPagarService = contasPagarService;
    }

    @PostMapping("/lancar")
    public ResponseEntity<List<RecResumoContasPagar>> lancar(@RequestBody RecLancaContasPagar request) {
        var parcelas = contasPagarService.lancar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(parcelas);
    }
}
