package time.SpringBootRabbitMQ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 1. 单播（点对点）
     */
    @Test
    public void contextLoads() {
        // message需要自己构造，定制消息体内容和消息头
        // rabbitTemplate.send(exchange,routeKey,message);
        // Object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloWorld",123,true));
        // 对象使用默认序列化方法以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","time.news",map);
    }

    @Test
    public void test(){
        Object o = rabbitTemplate.receiveAndConvert("time.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    // 定制自己的序列化方法，进行发送。需要配置自己MessageConvert，让对象以json的数据发送出去
    @Test
    public void test1(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloWorld",123,true));
        // 对象使用默认序列化方法以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","time.news",map);
    }

    // 利用AmqpAdmin管理组件
    @Autowired
    AmqpAdmin amqpAdmin;
    @Test
    public void test2(){
        // 利用amqpAdmin创建交换器
        amqpAdmin.declareExchange(new DirectExchange("amqp"));
        // 利用amqpAdmin创建消息队列
        amqpAdmin.declareQueue(new Queue("amqp.queue",true));
        // 利用amqpAdmin将交换器和队列绑定
        amqpAdmin.declareBinding(new Binding("amqp.queue", Binding.DestinationType.QUEUE,
                "amqp","amqp",null ));

    }
}
