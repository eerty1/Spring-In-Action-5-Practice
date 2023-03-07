//package tacos.domain.mongo_specific_domain;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.Date;
//import java.util.List;
//
//@Document
//public class TacoM {
//    @Id
//    private final String id;
//
//    @NotNull
//    @Size(min = 5, message = "Name must be at least 5 characters long")
//    private String name;
//
//    private Date createdAt = new Date();
//
//    @Size(min = 1, message = "You must choose at least one ingredient")
//    private List<Ingredient> ingredients;
//
//}
