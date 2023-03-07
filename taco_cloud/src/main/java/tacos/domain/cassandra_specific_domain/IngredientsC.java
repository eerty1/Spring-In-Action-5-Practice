//package tacos.domain.cassandra_specific_domain;
//
//import org.springframework.data.cassandra.core.mapping.PrimaryKey;
//import org.springframework.data.cassandra.core.mapping.Table;
//
//@Table("ingredients")
//public class IngredientsC {
//    @PrimaryKey
//    private final String id;
//    private final String name;
//    private final Type type;
//
//    public IngredientsC(String id, String name, Type type) {
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
