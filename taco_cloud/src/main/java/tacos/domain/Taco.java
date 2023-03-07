package tacos.domain;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "taco")
@RestResource(rel = "tacos", path = "tacos")
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    @Column(name = "nametaco")
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    @NotEmpty(message = "You must choose at least one ingredient")
    private List<Ingredient> ingredients;
    @Column(name = "createdat")
    private Date createdAt;

    public Taco() {
    }

    public Taco(Long id, String name, List<Ingredient> ingredients, Date createdAt) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.createdAt = createdAt;
    }

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAd) {
        this.createdAt = createdAd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taco taco = (Taco) o;
        return Objects.equals(id, taco.id) && Objects.equals(name, taco.name) && Objects.equals(ingredients, taco.ingredients) && Objects.equals(createdAt, taco.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ingredients, createdAt);
    }

    @Override
    public String toString() {
        return "Taco{" + "id=" + id + ", name='" + name + '\'' + ", ingredients=" + ingredients + ", createdAd=" + createdAt + '}';
    }
}
