package projeto_farmacia.roecker.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimentacao tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrigemMovimentacao origem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoItem itemTipo;

    @Column(nullable = false)
    private Integer itemId;

    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal quantidade;

    @Column(nullable = false)
    private LocalDateTime data;

    @PrePersist
    public void prePersist() {
        this.data = LocalDateTime.now();
    }
}