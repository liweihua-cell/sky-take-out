package consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqListener {

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String msg){
        System.out.println("消费者收到了simple.queue的消息："+msg);
    }

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue1(String msg){
        System.out.println("消费者1收到了work.queue的消息："+msg);
    }

    //fanout全局广播，发送给所有消费者
    @RabbitListener(queues = "fanout.queue")
    public void listenFanoutQueue1(String msg){
        System.out.println("消费者1收到了fanout.queue的消息："+msg);
    }

    //direct指定一个消费者发送
    @RabbitListener(queues = "direct.queue")
    public void listenDirectQueue1(String msg){
        System.out.println("消费者1收到了direct.queue的消息："+msg);
    }



    //声明队列和交换机的方式2（基于注解嵌套实现）
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "fanout.queue",durable = "true"),
            exchange = @Exchange(name = "lihua.fanout",type = ExchangeTypes.FANOUT),
            key = {"zhangsan"}
    ))
    public void listenFanoutQueue2(String msg){
        System.out.println("消费者1收到了fanout.queue的消息："+msg);
    }



    //发送延迟消息
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "delay.queue",durable = "true"),
            exchange = @Exchange(value = "delay.direct",delayed = "true"),
            key = "hi"
    ))
    public void listenerDelayQueue(String msg){
        log.info("接受到delay.queue的消息:"+msg);
    }
}
