//package tacos.rabbit_messaging;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.stereotype.Component;
//import tacos.domain.Order;
//
//@Component
//public class RabbitOrderReceiver {
//    private RabbitTemplate rabbitTemplate;
//    private MessageConverter messageConverter;
//
//    @Autowired
//    public RabbitOrderReceiver(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//        this.messageConverter = rabbitTemplate.getMessageConverter();
//    }
//
////    public Order receiveOrder() {
////        Message message = rabbitTemplate.receive("tacocloud.orders");
////        return message != null
////                ? (Order) messageConverter.fromMessage(message)
////                : null;
////    }
//
//    //here usual class casting is optional
//    public Order receiveOrder() {
//        return rabbitTemplate.receiveAndConvert("TestQueue", ParameterizedTypeReference.forType(Order.class));
//    }
//}
