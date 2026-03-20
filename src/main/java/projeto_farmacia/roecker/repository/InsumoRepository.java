package projeto_farmacia.roecker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto_farmacia.roecker.model.Insumo;

public interface InsumoRepository extends JpaRepository<Insumo, Integer> {

    Insumo findByNome(String nome);
    Insumo findByTipo(String tipo);
    Insumo findByFabricante(String fabricante);
    Insumo findByFornecedor(String fornecedor);
}
