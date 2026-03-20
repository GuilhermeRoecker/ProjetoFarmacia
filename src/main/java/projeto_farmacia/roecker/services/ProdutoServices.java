package projeto_farmacia.roecker.services;

import projeto_farmacia.roecker.model.Produto;
import projeto_farmacia.roecker.repository.ProdutoRepository;

public class ProdutoServices {

    private final ProdutoRepository produtoRepository;

    public ProdutoServices(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Integer id, Produto produto) {
        if (produtoRepository.existsById(id)) {
            produto.setId(id);
            return produtoRepository.save(produto);
        }
        return null;
    }

    public void deleteProduto(Integer id) {
        produtoRepository.deleteById(id);
    }

    public Produto getProdutoById(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Iterable<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoByName(String nome) {
        return produtoRepository.findByNome(nome);
    }

    public Produto getProdutoByAtivo(Boolean ativo) {
        return produtoRepository.findByAtivo(ativo);
    }
}
