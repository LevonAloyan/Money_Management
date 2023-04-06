package com.epam.money_management.constants;

public enum Currency {

    USD("$"),
    AMD("֏"),
    RUR("₽"),
    EUR("€");

    private final String currency;

    Currency(String currency){
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
