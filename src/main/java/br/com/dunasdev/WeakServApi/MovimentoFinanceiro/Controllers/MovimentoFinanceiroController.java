package br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Controllers;

import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Models.MovimentoCaixa;
import br.com.dunasdev.WeakServApi.MovimentoFinanceiro.Service.MovimentoFinanceiroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movimento-financeiro")
public class MovimentoFinanceiroController {
    private final MovimentoFinanceiroService movService;

    public MovimentoFinanceiroController(MovimentoFinanceiroService movService) {
        this.movService = movService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MovimentoCaixa>> listar() {
        return org.springframework.http.ResponseEntity.ok(movService.listarTodos());
    }
}
