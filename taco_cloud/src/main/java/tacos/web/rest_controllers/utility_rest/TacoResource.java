package tacos.web.rest_controllers.utility_rest;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import tacos.domain.Taco;
import tacos.web.rest_controllers.utility_rest.assemblers.IngredientResourceAssembler;

import java.util.Date;

@Relation(value = "taco", collectionRelation = "tacos")
public class TacoResource extends RepresentationModel<TacoResource> {

    private static final IngredientResourceAssembler ingredientAssembler = new IngredientResourceAssembler();
    private final String name;
    private final Date createdAt;
    private final CollectionModel<IngredientResource> ingredients;

    public TacoResource(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = ingredientAssembler.toCollectionModel(taco.getIngredients());
    }

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public CollectionModel<IngredientResource> getIngredients() {
        return ingredients;
    }
}
