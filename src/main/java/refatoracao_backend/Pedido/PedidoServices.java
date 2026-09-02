package refatoracao_backend.Pedido;

import org.springframework.stereotype.Service;
import refatoracao_backend.Cliente.clienteServices;
import refatoracao_backend.Estoque.estoqueServices;
import refatoracao_backend.Estoque.itemPedido;
import refatoracao_backend.Produto.produto;
import refatoracao_backend.Email.emailService;
import java.math.BigDecimal;

@Service
public class PedidoServices {

    private final clienteServices clienteServices;
    private final estoqueServices estoqueServices;
    private final calculo calculo;
    private final pedidoRepository pedidoRepository;
    private final emailService emailService;

    public PedidoServices(
            clienteServices clienteServices,
            estoqueServices estoqueServices,
            calculo calculo,
            pedidoRepository pedidoRepository,
            emailService emailService) {

        this.clienteServices = clienteServices;
        this.estoqueServices = estoqueServices;
        this.calculo = calculo;
        this.pedidoRepository = pedidoRepository;
        this.emailService = emailService;
    }

    public pedido criarPedido(pedido pedido) {

        clienteServices.buscarCliente(
                pedido.getCliente().getId()
        );

        BigDecimal total = BigDecimal.ZERO;

        for (itemPedido item : pedido.getItens()) {

            produto produto = estoqueServices.baixarEstoque(item);

            BigDecimal subtotal = calculo.calcularSubtotal(
                    produto,
                    item.getQuantidade()
            );

            total = total.add(subtotal);
        }

        pedido.setTotal(total);
        pedido.setStatus("CRIADO");

        pedido salvo = pedidoRepository.save(pedido);

        emailService.enviarConfirmacao(salvo);

        return salvo;
    }
}