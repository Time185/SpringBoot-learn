package time.SpringBootRabbitMQ;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RabbitMQ自动配置原理：
 *      1.自动配置类：RabbitAutoConfiguration
 *      2.自动配置了连接工厂：ConnectionFactory
 *      3.RabbitProperties: 封装了RabbitMQ的配置
 *      4.RabbitTemplate: 给RabbitMQ发送消息
 *      5. AmqpAdmin： RabbitMQ系统管理组件
 *
 *
 *
 */
@EnableRabbit // 开启RabbitMQ注解支持
@SpringBootApplication
public class RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }

}
