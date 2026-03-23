package projeto_farmacia.roecker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto_farmacia.roecker.model.FormulaItem;

public interface FormulaItemRepository extends JpaRepository<FormulaItem, Integer> {

    List<FormulaItem> findByFormulaId(Integer formulaId);
}
