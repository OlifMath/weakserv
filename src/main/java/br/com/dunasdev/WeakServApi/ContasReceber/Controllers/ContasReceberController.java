package br.com.dunasdev.WeakServApi.ContasReceber.Controllers;

import br.com.dunasdev.WeakServApi.ContasReceber.Records.RecLancaContasReceber;
import br.com.dunasdev.WeakServApi.ContasReceber.Records.RecResumoContasReceber;
import br.com.dunasdev.WeakServApi.ContasReceber.Services.ContasReceberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contas-receber")
public class ContasReceberController {

    private final ContasReceberService contasReceberService;

    public ContasReceberController(ContasReceberService contasReceberService) {
        this.contasReceberService = contasReceberService;
    }

    @PostMapping("/lancar")
    public ResponseEntity<List<RecResumoContasReceber>> lancar(@RequestBody RecLancaContasReceber request) {
        var parcelas = contasReceberService.lancar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(parcelas);
    }
}
