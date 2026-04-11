package br.com.dunasdev.WeakServApi.Clientes.Records;
import br.com.dunasdev.WeakServApi.Clientes.Models.Clientes;

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
}