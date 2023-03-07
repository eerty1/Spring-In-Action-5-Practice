package tacos.rest_consumer;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tacos.domain.Ingredient;
import tacos.domain.Order;

import java.net.URI;

@Component
public class TacoCloudClient {
    private RestTemplate restTemplate = new RestTemplate();

    private Traverson traverson = new Traverson(URI.create("http://localhost:8080/api"), MediaType.APPLICATION_JSON);

    public Ingredient getIngredientById(String ingredientId) {
        return restTemplate.getForObject("http://localhost:8080/ingredients/{id}", Ingredient.class, ingredientId);
    }

    public void deleteIngredient(String ingredientId) {
        restTemplate.delete("http://localhost:8080/ingredients/{id}", ingredientId);
    }

    public Iterable<Ingredient> getRecentTacoWithTraverson() {
        ParameterizedTypeReference<CollectionModel<Ingredient>> ingredientType = new ParameterizedTypeReference<CollectionModel<Ingredient>>() {};
        CollectionModel<Ingredient> tacoCollectionModel = traverson
                .follow("ingredients")
                .toObject(ingredientType);
        return tacoCollectionModel.getContent();
    }

    public Order getSingleOrder() {
        return restTemplate.getForObject("http://localhost:8080/orders/{orderId}", Order.class, 2);
    }

//    public Ingredient getIngredientById(String ingredientId) {
//        Map<String, String> urlVariables = new HashMap<>();
//        urlVariables.put("id", ingredientId);
//        return restTemplate.getForObject("http://localhost:8080/ingredients/{id}", Ingredient.class, urlVariables);
//    }

//    public Ingredient getIngredientById(String ingredientId) {
//        ResponseEntity<Ingredient> responseEntity = restTemplate.getForEntity("http://localhost:8080/ingredients/{id}", Ingredient.class, ingredientId);
//        Long responseDate = responseEntity.getHeaders().getDate();
//        System.out.println(responseDate);
//        return responseEntity.getBody();
//    }
}
