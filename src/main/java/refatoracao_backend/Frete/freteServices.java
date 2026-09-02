package refatoracao_backend.Frete;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class freteServices {

    public boolean freteGratis(BigDecimal valorPedido, boolean clientePremium) {

        if (clientePremium) {
            return valorPedido.compareTo(BigDecimal.valueOf(200)) > 0;
        }

        return valorPedido.compareTo(BigDecimal.valueOf(500)) > 0;
    }
}