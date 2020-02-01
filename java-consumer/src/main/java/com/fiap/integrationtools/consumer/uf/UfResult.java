package com.fiap.integrationtools.consumer.uf;

public class UfResult {
    private Double value;
    private Integer amount;

    public UfResult(Double value, Integer amount) {
        this.value = value;
        this.amount = amount;
    }

   public void addValue(Double value) {
       this.value += value;
   }

    public void addAmount(Integer amount) {
        this.amount += amount;
    }

    public Double getValue() {
        return value;
    }

    public Integer getAmount() {
        return amount;
    }
}
