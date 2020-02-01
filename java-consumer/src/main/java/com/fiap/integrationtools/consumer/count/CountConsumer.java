package com.fiap.integrationtools.consumer.count;

import com.fiap.integrationtools.consumer.Recipient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;


@Slf4j
@EnableBinding(CountChannel.class)
public class CountConsumer {

    private Integer counter = 0;

    @StreamListener(target = CountChannel.INPUT)
    public void handle(@Payload Recipient message) {
        counter ++;
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n\n\n************ Início - Contador de beneficiários ************\n");
        stringBuilder.append("Quantidade de beneficiários atual: " + counter + "\n");
        stringBuilder.append("************ Fim - Contador de beneficiários ************\n\n\n");
        System.out.println(stringBuilder.toString());
    }
}
