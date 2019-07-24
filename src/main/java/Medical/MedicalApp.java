package Medical;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableRabbit//开启Rabbit注解开发
@EnableScheduling//开启定时任务
@EnableSwagger2//开启swagger配置
@EnableCaching//redis缓存
@SpringBootApplication
public class MedicalApp {

	public static void main(String[] args) {
		SpringApplication.run(MedicalApp.class, args);
		System.out.println("*****校园医疗管理系统启动成功*****");

  }
	
}
