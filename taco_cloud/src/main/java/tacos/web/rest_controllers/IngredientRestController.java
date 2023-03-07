package tacos.web.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacos.domain.Ingredient;
import tacos.data.jpa_repositories.IngredientRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/ingredients", produces = "application/json")
@CrossOrigin(origins = "*")
public class IngredientRestController {
    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientRestController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping
    public Iterable<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @GetMapping(path = "/{ingredientId}", produces = "application/json")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable String ingredientId) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId);
        if (ingredient.isPresent()) {
            return new ResponseEntity<>(ingredient.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //somewhy @pathVariable are not needed, coz we have all the data from @RequestBody. Assumed, that error can appear here.
    @PutMapping(path = "/{ingredientId}", consumes = "application/json")
    public Ingredient putIngredient(@RequestBody Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @PatchMapping(path = "/{ingredientId}", consumes = "application/json")
    public Ingredient patchIngredient(@PathVariable String ingredientId, @RequestBody Ingredient bodyIngredient) {
        Ingredient ingredientToPatch = ingredientRepository.findById(ingredientId).get();
        if (bodyIngredient.getId() != null) {
            ingredientToPatch.setId(bodyIngredient.getId());
        }
        if (bodyIngredient.getName() != null) {
            ingredientToPatch.setName(bodyIngredient.getName());
        }
        if (bodyIngredient.getType() != null) {
            ingredientToPatch.setType(bodyIngredient.getType());
        }
        return ingredientRepository.save(ingredientToPatch);
    }

    @DeleteMapping(path = "/{ingredientId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteIngredient(@PathVariable String id) {
        try {
            ingredientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ignored) {

        }
    }
}
