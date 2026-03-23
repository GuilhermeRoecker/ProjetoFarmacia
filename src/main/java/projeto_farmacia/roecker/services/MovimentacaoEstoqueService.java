package projeto_farmacia.roecker.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import projeto_farmacia.roecker.model.MovimentacaoEstoque;
import projeto_farmacia.roecker.model.OrigemMovimentacao;
import projeto_farmacia.roecker.model.TipoItem;
import projeto_farmacia.roecker.model.TipoMovimentacao;
import projeto_farmacia.roecker.repository.MovimentacaoEstoqueRepository;

@Service
public class MovimentacaoEstoqueService {

    private final MovimentacaoEstoqueRepository repository;

    public MovimentacaoEstoqueService(MovimentacaoEstoqueRepository repository) {
        this.repository = repository;
    }

    public MovimentacaoEstoque registrar(
            TipoMovimentacao tipo,
            OrigemMovimentacao origem,
            Integer itemId,
            TipoItem itemTipo,
            BigDecimal quantidade) {

        if (quantidade == null || quantidade.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Quantidade inválida para movimentação");
        }

        MovimentacaoEstoque mov = new MovimentacaoEstoque();

        mov.setTipo(tipo);
        mov.setOrigem(origem);
        mov.setItemId(itemId);
        mov.setItemTipo(itemTipo);
        mov.setQuantidade(quantidade);
        mov.setData(LocalDateTime.now());

        return repository.save(mov);
    }

    public void registrarEntradaProduto(Integer produtoId, BigDecimal qtd) {
        registrar(
                TipoMovimentacao.ENTRADA,
                OrigemMovimentacao.PRODUCAO,
                produtoId,
                TipoItem.PRODUTO,
                qtd);
    }

    public void registrarSaidaInsumo(Integer insumoId, BigDecimal qtd) {
        registrar(
                TipoMovimentacao.SAIDA,
                OrigemMovimentacao.PRODUCAO,
                insumoId,
                TipoItem.INSUMO,
                qtd);
    }
}