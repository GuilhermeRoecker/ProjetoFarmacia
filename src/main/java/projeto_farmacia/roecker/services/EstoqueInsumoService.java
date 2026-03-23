package projeto_farmacia.roecker.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import projeto_farmacia.roecker.model.EstoqueInsumo;
import projeto_farmacia.roecker.model.Insumo;
import projeto_farmacia.roecker.repository.EstoqueInsumoRepository;

@Service
public class EstoqueInsumoService {

    private final EstoqueInsumoRepository estoqueInsumoRepository;

    public EstoqueInsumoService(EstoqueInsumoRepository estoqueInsumoRepository) {
        this.estoqueInsumoRepository = estoqueInsumoRepository;
    }

    public EstoqueInsumo getByInsumoId(Integer insumoId) {
        return estoqueInsumoRepository.findByInsumoId(insumoId)
                .orElseThrow(() -> new RuntimeException("Estoque do insumo não encontrado"));
    }

    public EstoqueInsumo criarEstoque(Insumo insumo, BigDecimal estoqueMinimo) {

        estoqueInsumoRepository.findByInsumoId(insumo.getId())
                .ifPresent(e -> {
                    throw new RuntimeException("Estoque já existe para esse insumo");
                });

        EstoqueInsumo estoque = new EstoqueInsumo();
        estoque.setInsumo(insumo);
        estoque.setQuantidade(BigDecimal.ZERO);
        estoque.setEstoqueMinimo(estoqueMinimo);

        return estoqueInsumoRepository.save(estoque);
    }

    public EstoqueInsumo adicionarEstoque(Integer insumoId, BigDecimal quantidade) {

        EstoqueInsumo estoque = getByInsumoId(insumoId);

        estoque.setQuantidade(estoque.getQuantidade().add(quantidade));

        return estoqueInsumoRepository.save(estoque);
    }

    public EstoqueInsumo removerEstoque(Integer insumoId, BigDecimal quantidade) {

        EstoqueInsumo estoque = getByInsumoId(insumoId);

        if (estoque.getQuantidade().compareTo(quantidade) < 0) {
            throw new RuntimeException("Estoque insuficiente");
        }

        estoque.setQuantidade(estoque.getQuantidade().subtract(quantidade));

        return estoqueInsumoRepository.save(estoque);
    }

    public boolean abaixoDoMinimo(Integer insumoId) {
        EstoqueInsumo estoque = getByInsumoId(insumoId);
        return estoque.getQuantidade().compareTo(estoque.getEstoqueMinimo()) < 0;
    }
}
