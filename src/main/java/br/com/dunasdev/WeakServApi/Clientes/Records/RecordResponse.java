package br.com.dunasdev.WeakServApi.Clientes.Records;
import br.com.dunasdev.WeakServApi.Clientes.Models.Clientes;

import java.util.List;

public record RecordResponse(
        Integer codCliente,
        String nome,
        String CGCCPF
) {
    public static RecordResponse from(Clientes cliente) {
        return new RecordResponse(
                cliente.getCodCliente(),
                cliente.getNome(),
                cliente.getCGCCPF()
        );
    }

    public static List<RecordResponse> from(List<Clientes> clientes) {
        return clientes.stream().map(RecordResponse::from).toList();
    }
}