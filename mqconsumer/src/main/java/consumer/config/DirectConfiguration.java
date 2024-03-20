package consumer.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//声明队列和交换机的方式
@Configuration
public class DirectConfiguration {

    @Bean
    public DirectExchange directExchange(){
        //ExchangeBuilder.directExchange("lihua.fanout1");
        return new DirectExchange("lihua.fanout1");
    }

    @Bean
    public Queue directQueue(){
        //QueueBuilder.durable("fanout.queue");
        return new Queue("fanout.queue");
    }

    @Bean
    public Binding directBinding(Queue fanoutQueue,DirectExchange directExchange){
        return BindingBuilder.bind(fanoutQueue).to(directExchange).with("zhangsan");
    }
}
