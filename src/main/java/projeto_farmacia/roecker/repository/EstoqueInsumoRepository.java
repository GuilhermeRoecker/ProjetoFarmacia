package projeto_farmacia.roecker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto_farmacia.roecker.model.EstoqueInsumo;

public interface EstoqueInsumoRepository extends JpaRepository<EstoqueInsumo, Integer> {

    Optional<EstoqueInsumo> findByInsumoId(Integer insumoId);
}
