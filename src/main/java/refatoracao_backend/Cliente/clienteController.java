package refatoracao_backend.Cliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import refatoracao_backend.Cliente.clienteServices;

@RestController
@RequestMapping("/clientes")
public class clienteController {

    private final clienteServices clienteServices;

    public clienteController(clienteServices clienteServices) {

        this.clienteServices = clienteServices;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody cliente cliente) {
        return clienteServices.cadastrar(cliente);
    }
}