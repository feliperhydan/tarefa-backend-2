package refatoracao_backend.Estoque;

import jakarta.persistence.*;
import refatoracao_backend.Produto.produto;

@Entity
public class itemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private produto produto;

    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public produto getProduto() {
        return produto;
    }

    public void setProduto(produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}