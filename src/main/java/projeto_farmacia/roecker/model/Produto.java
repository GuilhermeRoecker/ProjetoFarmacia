package projeto_farmacia.roecker.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull(message = "O campo nome é obrigatório")
    private String nome;

    @Column
    private BigDecimal preco_venda;

    @Column
    @NotNull(message = "O campo nome é obrigatório")
    private boolean ativo;
}
