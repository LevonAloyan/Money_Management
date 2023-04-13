package com.epam.money_management.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Comparator;

import static com.epam.money_management.constants.GlobalConstants.*;

public class CreditorDto {
    private Long id;
    @NotBlank(message = EMPTY_FIELD_MSG)
    private String name;
    @NotBlank(message = EMPTY_FIELD_MSG)
    private String surname;
    @NotBlank(message = EMPTY_FIELD_MSG)
    @Pattern(regexp = PHONE_REGEXP, message = PHONE_FIELD_MSG)
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static Comparator<CreditorDto> getNameSurnameComparator() {
        return Comparator.comparing(CreditorDto::getName)
                .thenComparing(CreditorDto::getSurname);
    }

    @Override
    public String toString() {
        return "CreditorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
