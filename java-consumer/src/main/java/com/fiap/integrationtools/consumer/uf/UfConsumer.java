package com.fiap.integrationtools.consumer.uf;

import com.fiap.integrationtools.consumer.Recipient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@EnableBinding(UfChannel.class)
public class UfConsumer {

    private Map<String, UfResult> resultMap = new HashMap<>();

    @StreamListener(target = UfChannel.INPUT)
    public void handle(@Payload Recipient message) {

        if (resultMap.containsKey(message.getUf())) {
            UfResult result = resultMap.get(message.getUf());
            result.addAmount(1);
            result.addValue(message.getInstallmentValue());
        } else {
            resultMap.put(message.getUf(), new UfResult(message.getInstallmentValue(), 1));
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n***************Início - Resumo por UF***************\n");

        resultMap.forEach(((s, ufResult) -> {
            stringBuilder.append(s);
            stringBuilder.append(" - Valor total parcelas: ");
            stringBuilder.append(ufResult.getValue());
            stringBuilder.append(", Beneficiários: ");
            stringBuilder.append(ufResult.getAmount());
            stringBuilder.append("\n");
        }));

        stringBuilder.append("\n***************Fim - Resumo por UF***************");

        System.out.println(stringBuilder.toString());
    }
}
