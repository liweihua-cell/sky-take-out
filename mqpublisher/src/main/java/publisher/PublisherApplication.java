package publisher;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PublisherApplication {
    public static void main(String[] args) {
        SpringApplication.run(PublisherApplication.class);
    }


    //消息转换器（未生效）
    @Bean
    public Jackson2JsonMessageConverter jacksonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
