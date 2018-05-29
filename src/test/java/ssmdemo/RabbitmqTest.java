package ssmdemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:生产消息测试
 * @Author: 5385
 * @Date 2018/5/29
 * @Time 11:25
 */
public class RabbitmqTest {
    public static void main(String[] args) throws InterruptedException {
            ClassPathXmlApplicationContext xtc = new ClassPathXmlApplicationContext("classpath:applicationContext-rabbitmq.xml");
        RabbitTemplate template = xtc.getBean(RabbitTemplate.class);
        template.convertAndSend("zhujinfan!");
        Thread.sleep(1000);
        xtc.close();
    }
}
