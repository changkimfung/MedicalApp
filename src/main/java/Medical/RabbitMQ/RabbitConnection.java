package Medical.RabbitMQ;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Configuration
public class RabbitConnection {

  private final Logger logger = LoggerFactory.getLogger(RabbitConnection.class);

  @Value("${spring.rabbitmq.host}")
  private  static String host;

  @Value("${spring.rabbitmq.port}")
  private  static int port;

  @Value("${spring.rabbitmq.username}")
  private static String username;

  @Value("${spring.rabbitmq.password}")
  private static String password;

//  @Bean
//  public  static Connection getConnection() throws IOException, TimeoutException {
//    ConnectionFactory connectionFactory=new ConnectionFactory();
//    connectionFactory.setUsername(username);
//    connectionFactory.setPassword(password);
//    connectionFactory.setPort(port);
//    connectionFactory.setVirtualHost(host);
//    Connection connection=connectionFactory.newConnection();
//    return connection;
//  }

  @Bean
  public  static ConnectionFactory getConnection() throws IOException, TimeoutException {
    ConnectionFactory connectionFactory=new ConnectionFactory();
    connectionFactory.setUsername(username);
    connectionFactory.setPassword(password);
    connectionFactory.setPort(port);
    connectionFactory.setVirtualHost(host);
    //Connection connection=connectionFactory.newConnection();
    return connectionFactory;
  }
}
