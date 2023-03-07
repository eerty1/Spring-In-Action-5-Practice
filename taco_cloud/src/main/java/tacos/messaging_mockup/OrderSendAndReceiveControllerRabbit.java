//package tacos.kitchen_bolvnka_to_check_if_everything_works;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import tacos.domain.Order;
//import tacos.rabbit_messaging.RabbitOrderMessagingService;
//import tacos.rabbit_messaging.RabbitOrderReceiver;
//import tacos.restClient.TacoCloudClient;
//
//import javax.jms.JMSException;
//
//@Controller
//@RequestMapping("/mq")
//public class OrderSendAndReceiveControllerRabbit {
//    private RabbitOrderMessagingService rabbitOrderMessagingService;
//    private RabbitOrderReceiver rabbitOrderReceiver;
//
//    private OrderListener orderListener;
//    private TacoCloudClient tacoCloudClient;
//    private KitchenUI kitchenUI;
//
//    @Autowired
//    public OrderSendAndReceiveControllerRabbit(RabbitOrderMessagingService rabbitOrderMessagingService,
//    RabbitOrderReceiver rabbitOrderReceiver, OrderListener orderListener, TacoCloudClient tacoCloudClient, KitchenUI kitchenUI) {
//        this.rabbitOrderMessagingService = rabbitOrderMessagingService;
//        this.rabbitOrderReceiver = rabbitOrderReceiver;
//        this.orderListener = orderListener;
//        this.tacoCloudClient = tacoCloudClient;
//        this.kitchenUI = kitchenUI;
//    }
//
//    @GetMapping("/send")
//    public String sendMessage() {
//        Order order = tacoCloudClient.getSingleOrder();
//        rabbitOrderMessagingService.sendOrder(order);
//        return "successfulOrder";
//    }
//
//    @GetMapping("/receive")
//    public String receiveMessage() throws JMSException {
//        Order order = rabbitOrderReceiver.receiveOrder();
//        kitchenUI.displayOrder(order);
//        return "noOrder";
//    }
//}
