package refatoracao_backend.Cliente;

import org.springframework.http.ResponseEntity;
import refatoracao_backend.Cliente.cliente;
import refatoracao_backend.Cliente.clienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class clienteServices {

    private final clienteRepository clienteRepository;

    public clienteServices(clienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ResponseEntity<?> cadastrar(cliente cliente) {

        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            return ResponseEntity.badRequest()
                    .body("Nome obrigatório");
        }

        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            return ResponseEntity.badRequest()
                    .body("Email já cadastrado");
        }

        cliente.setAtivo(true);
        cliente.setDataCadastro(LocalDateTime.now());

        return ResponseEntity.ok(cliente);
    }
    public cliente buscarCliente(Long id) {
        cliente cliente = clienteRepository
                .findById(id)
                .orElseThrow();

        if (!cliente.isAtivo()) {
            throw new RuntimeException("Cliente inativo");
        }

        return cliente;
    }
}