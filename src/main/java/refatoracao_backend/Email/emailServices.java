package refatoracao_backend.Email;

import org.springframework.stereotype.Service;
import refatoracao_backend.Pedido.pedido;

@Service
public class emailService {

    public void enviarConfirmacao(pedido pedido) {

        System.out.println(
                "Confirmação enviada para o pedido: "
                        + pedido.getId()
        );
    }
}