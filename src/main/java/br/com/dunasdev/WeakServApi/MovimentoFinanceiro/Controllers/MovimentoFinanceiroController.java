package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Controllers;

import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecRegistraTransacao;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecTransacaoResumo;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Service.MovimentoFinanceiroService;
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
    public ResponseEntity<List<RecTransacaoResumo>> listarTransacoes(@RequestParam LocalDate inicio, @RequestParam LocalDate fim) {
        LocalDateTime dataHoraInicio = inicio.atStartOfDay();
        LocalDateTime dataHoraFim = fim.atTime(LocalTime.MAX);
        
        return ResponseEntity.ok(movService.listarTransacoes(dataHoraInicio, dataHoraFim));
    }

    @PostMapping
    public ResponseEntity registrarTransacao(@RequestBody RecRegistraTransacao novaTransacao) {
        return ResponseEntity.ok().build();
    }
}