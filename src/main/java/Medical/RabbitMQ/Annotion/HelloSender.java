package Medical.RabbitMQ.Annotion;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


public class HelloSender  {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  public void send(){
    String simpleDateFormat=new SimpleDateFormat().format(new Date());
    String sendMsg="Hello sender01"+simpleDateFormat;
    System.out.println("the send01 is send***************");
    rabbitTemplate.convertSendAndReceive("Exchange01",null,sendMsg.getBytes());

  }
}
