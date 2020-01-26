package com.fiap.integrationtools.consumer.recipient;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RecipientChannel {

    String INPUT = "recipient_topic_recipient";

    @Input(INPUT)
    SubscribableChannel getSubscribableChannel();
}
