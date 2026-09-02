package refatoracao_backend.Pedido;

import org.springframework.web.bind.annotation.*;
import refatoracao_backend.Frete.freteServices;

import java.math.BigDecimal;

@RestController
@RequestMapping("/pedidos")
public class pedidoController {

    private final freteServices freteServices;

    public pedidoController(freteServices freteServices) {
        this.freteServices = freteServices;
    }

    @PostMapping
    public String criarPedido(
            @RequestParam BigDecimal valorPedido,
            @RequestParam boolean clientePremium) {

        if (freteServices.freteGratis(valorPedido, clientePremium)) {
            return "Pedido criado com frete grátis";
        }

        return "Pedido criado com frete";
    }
}