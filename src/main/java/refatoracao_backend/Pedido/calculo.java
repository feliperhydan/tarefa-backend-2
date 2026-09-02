package refatoracao_backend.Pedido;

import org.springframework.stereotype.Service;
import refatoracao_backend.Produto.produto;

import java.math.BigDecimal;

@Service
public class calculo {

    public BigDecimal calcularSubtotal(produto produto, Integer quantidade) {

        return produto.getPreco()
                .multiply(BigDecimal.valueOf(quantidade));
    }
}