package tacos.data.jpa_repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.domain.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
