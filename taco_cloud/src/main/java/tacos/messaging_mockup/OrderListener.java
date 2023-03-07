//package tacos.messaging_mockup;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//import tacos.domain.Order;
//
//@Component
//public class OrderListener {
//
//    private KitchenUI kitchenUI;
//
//    @Autowired
//    public OrderListener(KitchenUI kitchenUI) {
//        this.kitchenUI = kitchenUI;
//    }
//
//    @KafkaListener(topics = "TestTopic", groupId = "testgroup")
//    public void receiveOrder(Order order) {
//        System.out.println("es ist von hier gekommen");
//        kitchenUI.displayOrder(order);
//    }
//}
