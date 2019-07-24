package Medical.Task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class SechduleTask {
  private static final Logger LOG= LoggerFactory.getLogger(SechduleTask.class);


  @Scheduled(cron ="5/3 * * * * ? ")
  public void task01(){
    try {


      Job job = new Job();
      //job.sayHello();
      int a=job.sayHello();
    }
    catch (Exception e){
      LOG.error("is woring",e);
    }
    }

}
