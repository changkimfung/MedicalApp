package Medical.RabbitMQ.Core;

import Medical.domain.User;
import Medical.mapper.UserMapper;
import Medical.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者:类似于客户端 请求方
 */
@Api(value = "Core方式的Sender")
@RestController
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private UserMapper userService;

    @ApiOperation(value = "hello")
    @GetMapping(value = "/Hello")
    public int list(){

        this.rabbitTemplate.convertSendAndReceive("Jeffrey_exchange", "", "this is the sender for the core");

      return 1;
    }
}
