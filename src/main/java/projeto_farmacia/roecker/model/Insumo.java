package projeto_farmacia.roecker.model;

import java.math.BigDecimal;
import java.util.Date;

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
public class Insumo {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull(message = "O campo nome é obrigatório")
    private String nome;

    @Column
    private String tipo;

    @Column
    private String fabricante;

    @Column
    private String fornecedor;

    @Column
    private Date validade;

    @Column 
    private BigDecimal valor_unitario;

    @Column
    private BigDecimal valor_por_grama_ml;
}
