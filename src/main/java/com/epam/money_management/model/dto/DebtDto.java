package com.epam.money_management.model.dto;

import com.epam.money_management.constants.Currency;
import com.epam.money_management.constants.Type;
import com.epam.money_management.model.entity.Admin;
import com.epam.money_management.model.entity.Creditor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class DebtDto {
    private Long id;
    @NotNull(message = "Please, fill the required fields")
    private Type typeOfDebt;
    @Min(value = 1, message = "The debt value must be grater than 0")
    @NotNull(message = "Please, fill the required fields")
    private Long amount;
    @NotNull(message = "Please, fill the required field")
    private Currency currency;
    @NotNull(message = "Please, fill the required field")
    private LocalDate borrowingDate;
    @NotNull(message = "Please, fill the required field")
    private LocalDate returnDate;
    @NotNull(message = "Please, fill the required field")
    private Creditor creditor;
    private String note;
    @NotNull
    private Admin admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getTypeOfDebt() {
        return typeOfDebt;
    }

    public void setTypeOfDebt(Type typeOfDebt) {
        this.typeOfDebt = typeOfDebt;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Creditor getCreditor() {
        return creditor;
    }

    public void setCreditor(Creditor creditor) {
        this.creditor = creditor;
    }

    @Override
    public String toString() {
        return "DebtDto{" +
                "id=" + id +
                ", typeOfDebt=" + typeOfDebt +
                ", amount=" + amount +
                ", currency=" + currency +
                ", borrowingDate=" + borrowingDate +
                ", returnDate=" + returnDate +
                ", note='" + note + '\'' +
                ", admin=" + admin +
                ", creditor=" + creditor +
                '}';
    }
}
