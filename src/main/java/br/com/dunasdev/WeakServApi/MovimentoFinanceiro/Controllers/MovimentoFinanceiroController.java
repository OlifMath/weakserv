package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Controllers;

import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Records.RecQueryResumo;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Service.MovimentoFinanceiroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<List<RecQueryResumo>> listar(@RequestParam LocalDate inicio, @RequestParam LocalDate fim) {
        LocalDateTime dataHoraInicio = inicio.atStartOfDay();
        LocalDateTime dataHoraFim = fim.atTime(LocalTime.MAX);
        
        return ResponseEntity.ok(movService.listarMovimentacoes(dataHoraInicio, dataHoraFim));
    }
}