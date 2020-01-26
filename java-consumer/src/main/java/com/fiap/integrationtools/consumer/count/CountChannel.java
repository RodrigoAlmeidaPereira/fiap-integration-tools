package com.fiap.integrationtools.consumer.count;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CountChannel {

    String INPUT = "recipient_topic_count";

    @Input(INPUT)
    SubscribableChannel getSubscribableChannel();
}
