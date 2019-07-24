package Medical.MS;

import Medical.mapper.MsMapper;
import Medical.mapper.NumMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "ms")
@RestController
@RequestMapping("/MS")
public class MsController {

  @Autowired
  private NumMapper numMapper;

  @Autowired
  private MsMapper msMapper;

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private RedisTemplate redisTemplate;

  @ApiOperation(value = "test")
  @PostMapping(value = "/test")
  public String secKill(String mobile) {

    if (redisTemplate.hasKey("seckill:" + mobile)) {
      return "已抢到，请勿重复提交";
    }
    if (redisTemplate.hasKey("seckill:end")) {
      return "活动结束";
    }
    //向队列发送消息

    rabbitTemplate.convertAndSend("Jeffrey_exchange", "", mobile);
    //等待mq处理
    try {
      Thread.sleep(3000);
    } catch (Exception e) {
      e.printStackTrace();
      return "系统繁忙";
    }
    if (redisTemplate.hasKey("seckill:end")) {
      return "没抢到";
    }
    //查看活动是否结束
    if (redisTemplate.hasKey("seckill:end")) {

      return "没抢到!";
    }

    //MQ未处理完消息
    return "系统繁忙!";

  }


}

