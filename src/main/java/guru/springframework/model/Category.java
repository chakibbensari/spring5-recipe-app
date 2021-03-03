package guru.springframework.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany()
    @JoinTable(name="recipe_category",
               joinColumns = @JoinColumn(name = "recipe_id"),
               inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Recipe> recipes;

    public Category addRecipe(Recipe recipe){
        getRecipes().add(recipe);
        return this;
    }

    public Category removeRecipe(Recipe recipe){
        getRecipes().remove(recipe);
        return this;
    }

}
