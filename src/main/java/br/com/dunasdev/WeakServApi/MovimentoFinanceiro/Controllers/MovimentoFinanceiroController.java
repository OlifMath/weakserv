package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Controllers;

import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecRegistraTransacao;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecResumoTransacao;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Service.MovimentoFinanceiroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("api/movimento-financeiro")
public class MovimentoFinanceiroController {

    private final MovimentoFinanceiroService movService;

    public MovimentoFinanceiroController(MovimentoFinanceiroService movService) {
        this.movService = movService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<RecResumoTransacao>> listarTransacoes(@RequestParam LocalDate inicio, @RequestParam LocalDate fim) {
        LocalDateTime dataHoraInicio = inicio.atStartOfDay();
        LocalDateTime dataHoraFim = fim.atTime(LocalTime.MAX);
        
        return ResponseEntity.ok(movService.listarTransacoes(dataHoraInicio, dataHoraFim));
    }

    @PostMapping("/registrar")
    public ResponseEntity registrarTransacao(@RequestBody RecRegistraTransacao novaTransacao) {
        var transacaoSalva = movService.registrarTransacao(novaTransacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoSalva);
    }
}