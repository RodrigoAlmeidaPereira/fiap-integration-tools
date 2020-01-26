package com.fiap.integrationtools.consumer.recipient;

import com.fiap.integrationtools.consumer.Recipient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;


@Slf4j
@EnableBinding(RecipientChannel.class)
public class RecipientConsumer {

    @StreamListener(target = RecipientChannel.INPUT)
    public void handle(@Payload Recipient message) {
        log.info("Should process by recipient " + message);
    }
}
