package refatoracao_backend.Estoque;

import org.springframework.stereotype.Service;
import refatoracao_backend.Produto.produto;
import refatoracao_backend.Produto.produtoRepository;

@Service
public class estoqueServices {

    private final produtoRepository produtoRepository;

    public estoqueServices(produtoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public produto baixarEstoque(itemPedido item) {

        produto produto = produtoRepository
                .findById(item.getProduto().getId())
                .orElseThrow();

        if (produto.getEstoque() < item.getQuantidade()) {
            throw new RuntimeException("Estoque insuficiente");
        }

        produto.setEstoque(
                produto.getEstoque() - item.getQuantidade()
        );

        produtoRepository.save(produto);

        return produto;
    }
}