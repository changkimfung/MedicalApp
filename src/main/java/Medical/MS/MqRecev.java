package Medical.MS;

import Medical.domain.MS;
import Medical.domain.Num;
import Medical.mapper.MsMapper;
import Medical.mapper.NumMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MqRecev {

  @Autowired
  private NumMapper numMapper;

  @Autowired
  private MsMapper msMapper;

  @Autowired
  private RedisTemplate redisTemplate;

  @RabbitListener(queues = "Jeffrey_queue")
  public void Recever(String Msg){

    //查看活动是否已结束
    if (redisTemplate.hasKey("seckill:end")) {

      return;
    }
    int num=numMapper.find();
    if(num>0){
      MS ms=new MS();
      String time= SimpleDateFormat.getDateTimeInstance().format(new Date());
      ms.setId(time);
      ms.setPhone(Msg);
      msMapper.insertPhone(ms);
      numMapper.deleteNum();
      redisTemplate.opsForValue().set("secKill:"+Msg,"");
      System.out.println("MQReceive-->OK-->" +Msg);
    }
    else {
      redisTemplate.opsForValue().set("seckill:end","");
    }
  }
}
