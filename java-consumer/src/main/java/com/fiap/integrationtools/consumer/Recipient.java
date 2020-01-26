package com.fiap.integrationtools.consumer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Recipient {

    @JsonProperty("reference_month")
    private Integer referenceMonth;

    @JsonProperty("reference_year")
    private Integer referenceYear;

    @JsonProperty("competence_month")
    private Integer competenceMonth;

    @JsonProperty("competence_year")
    private Integer competenceYear;

    @JsonProperty("uf")
    private String uf;

    @JsonProperty("city_code")
    private String cityCode;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("recipient_nis")
    private String recipientNis;

    @JsonProperty("recipient_name")
    private String recipientName;

    @JsonProperty("installment_value")
    private Double installmentValue;

}
