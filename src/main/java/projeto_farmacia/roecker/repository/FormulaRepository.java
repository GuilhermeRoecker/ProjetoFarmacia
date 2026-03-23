package projeto_farmacia.roecker.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import projeto_farmacia.roecker.model.Formula;

public interface FormulaRepository extends JpaRepository<Formula, Integer> {

    Optional<Formula> findByProdutoId(Integer produtoId);
}
