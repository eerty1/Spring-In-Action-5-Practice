//package tacos.domain.mongo_specific_domain;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document
//public class IngredientM {
//
//    @Id
//    private final String id;
//    private final String name;
//    private final Type type;
//
//    public IngredientM(String id, String name, Type type) {
//        this.id = id;
//        this.name = name;
//        this.type = type;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Type getType() {
//        return type;
//    }
//
//    public static enum Type {
//        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
//    }
//}
