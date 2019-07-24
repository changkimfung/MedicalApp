package Medical.RabbitMQ.Core;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description MQ配置信息
 * <p>
 * 基于代码的绑定交换器、队列、路由键设置
 * 1. 声明Exchange(交换器名称,durable,autoDelete)
 * 2. 声明Queue(队列名称,durable,autoDelete)
 * 3. 绑定：BindingBuilder绑定队列到交换器，并设置路由键
 * @Author jxb
 * @Date 2019-03-10 10:25:30
 */


@Component
public class MqUtil {

  /**
   * @Description 创建1:1 类型交换器(direct)
   * new DirectExchange(String,boolean,boolean)
   * new FanoutExchange(String,boolean,boolean)
   * new TopicExchange(String,boolean,boolean)
   * 1. 交换器名称
   * 2. durable 是否持久化 默认true
   * 3. autoDelete 是否自动删除 默认false
   * @Author jxb
   * @Date 2019-03-02 14:26:59
   */
  @Bean
  private DirectExchange directExchange() {
    return new DirectExchange("Jeffrey_exchange");
  }

  /**
   * @Description 创建队列
   * new Queue(String,boolean,boolean,boolean)
   * 1. 队列名称
   * 2. durable 是否持久化 默认true
   * 3. exclusive 排他队列，第一个链接消费后自动删除 默认 false
   * 4. autoDelete 是否自动删除 默认false
   * @Author jxb
   * @Date 2019-03-02 14:12:31
   */
  @Bean
  private Queue directQueue() {
    return new Queue("Jeffrey_queue");
  }
  /**
   * 队列绑定到交换器
   */
  @Bean
  private Binding bindingDirect(){
    return BindingBuilder.bind(directQueue()).to(directExchange()).with("");
  }
}
