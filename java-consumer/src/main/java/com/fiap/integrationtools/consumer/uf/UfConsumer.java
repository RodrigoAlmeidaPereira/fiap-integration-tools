package com.fiap.integrationtools.consumer.uf;

import com.fiap.integrationtools.consumer.Recipient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;


@Slf4j
@EnableBinding(UfChannel.class)
public class UfConsumer {

    @StreamListener(target = UfChannel.INPUT)
    public void handle(@Payload Recipient message) {
        log.info("Should process by uf " + message);
    }
}
