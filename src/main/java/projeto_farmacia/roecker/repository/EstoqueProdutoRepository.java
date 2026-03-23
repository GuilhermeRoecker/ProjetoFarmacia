package projeto_farmacia.roecker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto_farmacia.roecker.model.EstoqueProduto;

public interface EstoqueProdutoRepository extends JpaRepository<EstoqueProduto, Integer> {

    Optional<EstoqueProduto> findByProdutoId(Integer produtoId);
}
