package com.fiap.integrationtools.consumer.recipient;

import com.fiap.integrationtools.consumer.Recipient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;


@Slf4j
@EnableBinding(RecipientChannel.class)
public class RecipientConsumer {

    private Recipient recHighestInstallment;

    @StreamListener(target = RecipientChannel.INPUT)
    public void handle(@Payload Recipient message) {
        if(recHighestInstallment == null){
            recHighestInstallment = message;
            printRecipient(recHighestInstallment);
        }else if(message.getInstallmentValue() > recHighestInstallment.getInstallmentValue()){
            recHighestInstallment = message;
            printRecipient(recHighestInstallment);
        }
    }

    private void printRecipient(Recipient recipient){
        StringBuilder builder = new StringBuilder();
        builder.append("\n\n\n");
        builder.append("************ Beneficiário com a maior parcela ************\n");
        builder.append("NIS_Favorecido: ");
        builder.append(recipient.getRecipientNis());
        builder.append("\n");
        builder.append("NOME_FAVORECIDO: ");
        builder.append(recipient.getRecipientName());
        builder.append("\n");
        builder.append("VALOR_PARCELA: ");
        builder.append(recipient.getInstallmentValue());
        builder.append("\n");
        builder.append("NOME_MUNICIPIO: ");
        builder.append(recipient.getCityName());
        builder.append("\n");
        builder.append("UF: ");
        builder.append(recipient.getUf());
        builder.append("\n");
        builder.append("----------------------------------------------");
        builder.append("\n\n\n");
        log.info(builder.toString());
    }

}
