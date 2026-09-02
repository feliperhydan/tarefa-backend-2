package refatoracao_backend.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface produtoRepository extends JpaRepository<produto, Long> {
}