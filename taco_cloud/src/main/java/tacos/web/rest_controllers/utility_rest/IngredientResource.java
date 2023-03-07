package tacos.web.rest_controllers.utility_rest;

import org.springframework.hateoas.RepresentationModel;
import tacos.domain.Ingredient;

import static tacos.domain.Ingredient.*;

public class IngredientResource extends RepresentationModel<IngredientResource> {
    private final String name;
    private final Type type;


    public IngredientResource(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
