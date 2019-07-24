package Medical.RabbitMQ.Core;

import Medical.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class Consumer {

  /**
   * @Description 监听队列之后从对应的队列拿数据
   */
 // @RabbitListener(queues = "Jeffrey_queue")
  public  void getSenderMsg( String a){

    System.out.println("MQConsumer--getDirectMessage："+a);
  }

}
