package Medical.RabbitMQ.Annotion;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


public class RabbitMqServer {


  public  void receive(Message message){
    System.out.println("队列中的信息----->+"+message.toString());
  }
}
