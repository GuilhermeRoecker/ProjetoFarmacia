package projeto_farmacia.roecker.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import projeto_farmacia.roecker.model.EstoqueProduto;
import projeto_farmacia.roecker.model.Produto;
import projeto_farmacia.roecker.repository.EstoqueProdutoRepository;

@Service
public class EstoqueProdutoService {

    private final EstoqueProdutoRepository estoqueProdutoRepository;

    public EstoqueProdutoService(EstoqueProdutoRepository estoqueProdutoRepository) {
        this.estoqueProdutoRepository = estoqueProdutoRepository;
    }

    public EstoqueProduto getByProdutoId(Integer produtoId) {
        return estoqueProdutoRepository.findByProdutoId(produtoId)
                .orElseThrow(() -> new RuntimeException("Estoque do produto não encontrado"));
    }

    public EstoqueProduto criarEstoque(Produto produto, BigDecimal estoqueMinimo) {

        estoqueProdutoRepository.findByProdutoId(produto.getId())
                .ifPresent(e -> {
                    throw new RuntimeException("Estoque já existe para esse produto");
                });

        EstoqueProduto estoque = new EstoqueProduto();
        estoque.setProduto(produto);
        estoque.setQuantidade(BigDecimal.ZERO);
        estoque.setEstoqueMinimo(estoqueMinimo);

        return estoqueProdutoRepository.save(estoque);
    }

    public EstoqueProduto adicionarEstoque(Integer produtoId, BigDecimal quantidade) {

        EstoqueProduto estoque = getByProdutoId(produtoId);

        estoque.setQuantidade(estoque.getQuantidade().add(quantidade));

        return estoqueProdutoRepository.save(estoque);
    }

    public EstoqueProduto removerEstoque(Integer produtoId, BigDecimal quantidade) {

        EstoqueProduto estoque = getByProdutoId(produtoId);

        if (estoque.getQuantidade().compareTo(quantidade) < 0) {
            throw new RuntimeException("Estoque insuficiente");
        }

        estoque.setQuantidade(estoque.getQuantidade().subtract(quantidade));

        return estoqueProdutoRepository.save(estoque);
    }

    public boolean abaixoDoMinimo(Integer produtoId) {
        EstoqueProduto estoque = getByProdutoId(produtoId);
        return estoque.getQuantidade().compareTo(estoque.getEstoqueMinimo()) < 0;
    }
}