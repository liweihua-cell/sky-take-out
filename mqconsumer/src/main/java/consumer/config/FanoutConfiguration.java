package consumer.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//声明队列和交换机的方式1（基于bean创建实现）
@Configuration
public class FanoutConfiguration {

    @Bean
    public FanoutExchange fanoutExchange(){
        //ExchangeBuilder.fanoutExchange("lihua.fanout1");
        return new FanoutExchange("lihua.fanout1");
    }

    @Bean
    public Queue fanoutQueue(){
        //QueueBuilder.durable("fanout.queue");
        return new Queue("fanout.queue");
    }

    @Bean
    public Binding fanoutBinding(Queue fanoutQueue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }
}
