//package tacos.rabbit_messaging;
//
//import org.springframework.amqp.core.MessageProperties;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import tacos.domain.Order;
//import tacos.jms_messaging.OrderMessagingService;
//
//@Service
//public class RabbitOrderMessagingService implements OrderMessagingService {
//
//    private RabbitTemplate rabbitTemplate;
//
//
//    @Autowired
//    public RabbitOrderMessagingService(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
////    the way to send a message with send() with creating message object yourself
////    @Override
////    public void sendOrder(Order order) {
////        MessageConverter messageConverter = rabbitTemplate.getMessageConverter();
////        MessageProperties messageProperties = new MessageProperties();
////        Message message = messageConverter.toMessage(order, messageProperties);
////        rabbitTemplate.send("tacocloud.order", message);
////    }
//
//
//    @Override
//    public void sendOrder(Order order) {
//        rabbitTemplate.convertAndSend("tacocloud.order", order, message -> {
//            MessageProperties messageProperties = message.getMessageProperties();
//            messageProperties.setHeader("X_ORDER_SOURCE", "WEB");
//            return message;
//        });
//    }
//}
