package service_client.rest_client;

import domain.Ingredient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IngredientClientService {
    private RestTemplate restTemplate;

    public IngredientClientService(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Ingredient getIngredientById(String ingredientId) {
        return restTemplate.getForObject("http://ingredient-service/ingredients/{id}", Ingredient.class, ingredientId);
    }
}
