//package tacos.domain.mongo_specific_domain;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Field;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Document
//public class OrderM {
//    @Id
//    private final String id;
//
//    private Date placedAt = new Date();
//
//    @Field("customer")
//    private UserM user;
//
//    private List<TacoM> tacos = new ArrayList<>();
//
//    public void addDesign(TacoM taco) {
//        tacos.add(taco);
//    }
//
//    public OrderM(String id, Date placedAt, UserM user, List<TacoM> tacos) {
//        this.id = id;
//        this.placedAt = placedAt;
//        this.user = user;
//        this.tacos = tacos;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public Date getPlacedAt() {
//        return placedAt;
//    }
//
//    public void setPlacedAt(Date placedAt) {
//        this.placedAt = placedAt;
//    }
//
//    public UserM getUser() {
//        return user;
//    }
//
//    public void setUser(UserM user) {
//        this.user = user;
//    }
//
//    public List<TacoM> getTacos() {
//        return tacos;
//    }
//
//    public void setTacos(List<TacoM> tacos) {
//        this.tacos = tacos;
//    }
//}
