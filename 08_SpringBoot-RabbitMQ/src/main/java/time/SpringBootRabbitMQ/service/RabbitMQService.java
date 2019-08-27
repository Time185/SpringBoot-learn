package time.SpringBootRabbitMQ.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Time
 * @created 2019/8/27
 *
 *
 * 注解@RabbitListener：监听一或多个个消息队列，当消息队列中存放消息，就获取消息
 */
@Service
public class RabbitMQService {
    @RabbitListener(queues = {"time.news"})
    public void receive(Map<String,Object> map){
        System.out.println(map);
    }
}
