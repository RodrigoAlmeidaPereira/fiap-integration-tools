package com.fiap.integrationtools.consumer.count;

import com.fiap.integrationtools.consumer.Recipient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;


@Slf4j
@EnableBinding(CountChannel.class)
public class CountConsumer {

    public static int count = 0;

    @StreamListener(target = CountChannel.INPUT)
    public void handle(@Payload Recipient message) {
        CountConsumer.count ++;        
        StringBuilder builder = new StringBuilder();
        builder.append("\n\n\n");
        builder.append("************ Consumption Count ************\n");
        builder.append("Should count: ");
        builder.append(CountConsumer.count);
        builder.append("\n");       
        builder.append("----------------------------------------------");
        builder.append("\n\n\n");
        log.info(builder.toString());

    }
}
