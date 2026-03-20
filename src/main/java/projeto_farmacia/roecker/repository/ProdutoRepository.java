package projeto_farmacia.roecker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto_farmacia.roecker.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Produto findByNome(String nome);
    Produto findByAtivo(Boolean ativo);
}
