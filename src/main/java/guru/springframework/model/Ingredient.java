package guru.springframework.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @OneToOne()
    private UnitOfMeasure uom;

    @ManyToOne()
    private Recipe recipe;

    public Long getId() {
        return id;
    }


}
