//package tacos.kitchen_bolvnka_to_check_if_everything_works;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import tacos.domain.Order;
//import tacos.jms_messaging.JmsOrderMessagingService;
//import tacos.jms_messaging.JmsOrderReceiver;
//import tacos.restClient.TacoCloudClient;
//
//import javax.jms.JMSException;
//
//@Controller
//@RequestMapping("/mq")
//public class OrderSendReceiveController {
//    private JmsOrderMessagingService jmsOrderMessagingService;
//    private JmsOrderReceiver orderReceiver;
//    private OrderListener orderListener;
//    private TacoCloudClient tacoCloudClient;
//    private KitchenUI kitchenUI;
//
//    @Autowired
//    public OrderSendReceiveController(JmsOrderMessagingService jmsOrderMessagingService,
//    JmsOrderReceiver orderReceiver, OrderListener orderListener, TacoCloudClient tacoCloudClient, KitchenUI kitchenUI) {
//        this.jmsOrderMessagingService = jmsOrderMessagingService;
//        this.orderReceiver = orderReceiver;
//        this.orderListener = orderListener;
//        this.tacoCloudClient = tacoCloudClient;
//        this.kitchenUI = kitchenUI;
//    }
//
//    @GetMapping("/send")
//    public String sendMessage() {
//        Order order = tacoCloudClient.getSingleOrder();
//        jmsOrderMessagingService.sendOrder(order);
//        return "successfulOrder";
//    }
//
//    @GetMapping("/receive")
//    public String receiveMessage() throws JMSException {
//        Order order = orderReceiver.receiveOrder();
//        kitchenUI.displayOrder(order);
//        return "noOrder";
//    }
//}
