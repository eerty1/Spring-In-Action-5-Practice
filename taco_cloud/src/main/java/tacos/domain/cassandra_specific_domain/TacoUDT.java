//package tacos.domain.cassandra_specific_domain;
//
//import org.springframework.data.cassandra.core.mapping.UserDefinedType;
//
//import java.util.List;
//
//@UserDefinedType("taco")
//public class TacoUDT {
//    private final String name;
//    private final List<IngredientUDT> ingredients;
//
//    public TacoUDT(String name, List<IngredientUDT> ingredients) {
//        this.name = name;
//        this.ingredients = ingredients;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public List<IngredientUDT> getIngredients() {
//        return ingredients;
//    }
//}
