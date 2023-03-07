//package tacos.messaging_mockup;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import tacos.domain.Order;
//import tacos.kafka_messaging.KafkaOrderMessagingService;
//import tacos.rest_consumer.TacoCloudClient;
//
//@Controller
//@RequestMapping("/mq")
//public class OrderSendAndReceiveControllerKafka {
//    private KafkaOrderMessagingService kafkaOrderMessagingService;
//    private TacoCloudClient tacoCloudClient;
//    private KitchenUI kitchenUI;
//
//    @Autowired
//    public OrderSendAndReceiveControllerKafka(KafkaOrderMessagingService kafkaOrderMessagingService,
//    TacoCloudClient tacoCloudClient, KitchenUI kitchenUI) {
//        this.kafkaOrderMessagingService = kafkaOrderMessagingService;
//        this.tacoCloudClient = tacoCloudClient;
//        this.kitchenUI = kitchenUI;
//    }
//
//    @GetMapping("/send")
//    public String sendMessage() {
//        Order order = tacoCloudClient.getSingleOrder();
//        kafkaOrderMessagingService.sendOrder(order);
//        return "successfulOrder";
//    }
//
////    @GetMapping("/receive")
////    public String receiveMessage() throws JMSException {
////        Order order = rabbitOrderReceiver.receiveOrder();
////        kitchenUI.displayOrder(order);
////        return "noOrder";
////    }
//}
//
