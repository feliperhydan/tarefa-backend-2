package refatoracao_backend.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface clienteRepository extends JpaRepository<cliente, Long> {

    boolean existsByEmail(String email);
}