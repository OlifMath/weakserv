package br.com.dunasdev.weakserv.CadastroClientes.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Clientes {

    @Id
    private Long codCliente;

    private String nome;

    public Clientes() {}

    public Long getCodCliente() { return codCliente; }
    public void setCodCliente(Long codCliente) { this.codCliente = codCliente; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
