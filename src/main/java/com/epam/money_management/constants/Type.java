package com.epam.money_management.constants;

public enum Type {

    LENT("Lent"),
    BORROWED("Borrowed");

    private final String type;

    Type(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

}
