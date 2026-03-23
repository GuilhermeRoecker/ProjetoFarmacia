package projeto_farmacia.roecker.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import projeto_farmacia.roecker.model.EstoqueInsumo;
import projeto_farmacia.roecker.model.Formula;
import projeto_farmacia.roecker.model.FormulaItem;
import projeto_farmacia.roecker.repository.FormulaItemRepository;
import projeto_farmacia.roecker.repository.FormulaRepository;

@Service
public class ProducaoService {

    private final FormulaRepository formulaRepository;
    private final FormulaItemRepository formulaItemRepository;
    private final EstoqueInsumoService estoqueInsumoService;
    private final EstoqueProdutoService estoqueProdutoService;

    public ProducaoService(
            FormulaRepository formulaRepository,
            FormulaItemRepository formulaItemRepository,
            EstoqueInsumoService estoqueInsumoService,
            EstoqueProdutoService estoqueProdutoService) {

        this.formulaRepository = formulaRepository;
        this.formulaItemRepository = formulaItemRepository;
        this.estoqueInsumoService = estoqueInsumoService;
        this.estoqueProdutoService = estoqueProdutoService;
    }

    @Transactional
    public void produzir(Integer produtoId, BigDecimal quantidadeProduzida) {

        Formula formula = formulaRepository.findByProdutoId(produtoId)
                .orElseThrow(() -> new IllegalStateException("Fórmula não encontrada para o produto"));

        List<FormulaItem> itens = formulaItemRepository.findByFormulaId(formula.getId());

        if (itens.isEmpty()) {
            throw new IllegalStateException("Fórmula sem insumos");
        }

        for (FormulaItem item : itens) {

            BigDecimal consumo = item.getQuantidade().multiply(quantidadeProduzida);

            EstoqueInsumo estoque = estoqueInsumoService.getByInsumoId(item.getInsumo().getId());

            if (estoque.getQuantidade().compareTo(consumo) < 0) {
                throw new IllegalStateException(
                        "Estoque insuficiente para o insumo: " + item.getInsumo().getNome()
                );
            }
        }

        for (FormulaItem item : itens) {

            BigDecimal consumo = item.getQuantidade().multiply(quantidadeProduzida);

            estoqueInsumoService.removerEstoque(
                    item.getInsumo().getId(),
                    consumo
            );
        }

        estoqueProdutoService.adicionarEstoque(produtoId, quantidadeProduzida);
    }
}
