package com.fiap.integrationtools.consumer.count;

import com.fiap.integrationtools.consumer.Recipient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;


@Slf4j
@EnableBinding(CountChannel.class)
public class CountConsumer {

    @StreamListener(target = CountChannel.INPUT)
    public void handle(@Payload Recipient message) {
        log.info("Should count " + message);
    }
}
