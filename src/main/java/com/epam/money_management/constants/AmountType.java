package com.epam.money_management.constants;

public enum AmountType {

    USD("$"),
    AMD("֏"),
    RUR("₽"),
    EUR("€");

    private final String amountType;

    AmountType(String amountType){
        this.amountType = amountType;
    }

    public String getAmountType(){
        return amountType;
    }
}
