package br.com.dunasdev.WeakServApi.Clientes.Records;
import br.com.dunasdev.WeakServApi.Clientes.Models.Clientes;

import java.util.List;

public record RecResponse(
        Integer codCliente,
        String nome,
        String CGCCPF
) {
    public static RecResponse from(Clientes cliente) {
        return new RecResponse(
                cliente.getCodCliente(),
                cliente.getNome(),
                cliente.getCGCCPF()
        );
    }

    public static List<RecResponse> from(List<Clientes> clientes) {
        return clientes.stream().map(RecResponse::from).toList();
    }
}