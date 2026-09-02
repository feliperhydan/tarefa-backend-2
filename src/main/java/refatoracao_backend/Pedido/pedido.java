package refatoracao_backend.Pedido;

import jakarta.persistence.*;
import refatoracao_backend.Cliente.cliente;
import refatoracao_backend.Estoque.itemPedido;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private cliente cliente;

    @OneToMany
    private List<itemPedido> itens;

    private BigDecimal total;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public List<itemPedido> getItens() {
        return itens;
    }

    public void setItens(List<itemPedido> itens) {
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}