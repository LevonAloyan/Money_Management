package com.epam.money_management.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Comparator;

import static com.epam.money_management.constants.ControllerHelper.PHONE_REGEXP;

public class CreditorDto {
    private Long id;
    @NotBlank(message = "{required.fields}")
    private String name;
    @NotBlank(message = "{required.fields}")
    private String surname;
    @NotBlank(message = "{required.fields}")
//    @Pattern(regexp = PHONE_REGEXP, message = "{phone.number}")
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

    public String getFullName() {
        return name + ' ' + surname;
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
