//package tacos.kafka_messaging;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//import tacos.domain.Order;
//import tacos.jms_messaging.OrderMessagingService;
//
//@Service
//public class KafkaOrderMessagingService implements OrderMessagingService {
//
//    private KafkaTemplate<String, Order> kafkaTemplate;
//
//    @Autowired
//    public KafkaOrderMessagingService(KafkaTemplate<String, Order> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//    @Override
//    public void sendOrder(Order order) {
//        kafkaTemplate.send("TestTopic", order);
//    }
//}
