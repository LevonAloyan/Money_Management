package com.epam.money_management.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "repayment")
public class DebtRepayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long repayment;
    LocalDate repaymentDate;
    Long residue;
    @ManyToOne
    Debt debt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRepayment() {
        return repayment;
    }

    public void setRepayment(Long repayment) {
        this.repayment = repayment;
    }

    public LocalDate getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(LocalDate repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Long getResidue() {
        return residue;
    }

    public void setResidue(Long residue) {
        this.residue = residue;
    }

    public Debt getDebt() {
        return debt;
    }

    public void setDebt(Debt debt) {
        this.debt = debt;
    }

    @Override
    public String toString() {
        return "DebtRepayment{" +
                "id=" + id +
                ", repayment=" + repayment +
                ", repaymentDate=" + repaymentDate +
                ", residue=" + residue +
                ", debt=" + debt +
                '}';
    }
}
