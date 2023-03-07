//package tacos.jms_messaging;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.support.converter.MessageConverter;
//import org.springframework.stereotype.Component;
//import tacos.domain.Order;
//import tacos.kitchen_bolvnka_to_check_if_everything_works.KitchenUI;
//
//import javax.jms.JMSException;
//
//@Component
//public class JmsOrderReceiver {
//    private JmsTemplate jmsTemplate;
//    private MessageConverter converter;
//    private KitchenUI kitchenUI;
//
//    @Autowired
//    public JmsOrderReceiver(JmsTemplate jmsTemplate, MessageConverter converter, KitchenUI kitchenUI) {
//        this.jmsTemplate = jmsTemplate;
//        this.converter = converter;
//        this.kitchenUI = kitchenUI;
//    }
//
//
//
//
////    public Order receiveOrder() throws JMSException {
////        Message message = jmsTemplate.receive("tacocloud.order.queue");
////        return (Order) converter.fromMessage(message);
////    }
//
//    public Order receiveOrder() throws JMSException {
//        return (Order) jmsTemplate.receiveAndConvert("tacocloud.order.queue");
//    }
//
//}
