package com.fiap.integrationtools.consumer.uf;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UfChannel {

    String INPUT = "recipient_topic_uf";

    @Input(INPUT)
    SubscribableChannel getSubscribableChannel();
}
