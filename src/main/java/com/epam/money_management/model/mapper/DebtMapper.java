package com.epam.money_management.model.mapper;

import com.epam.money_management.model.dto.DebtDto;
import com.epam.money_management.model.entity.Debt;

import java.util.List;
import java.util.stream.Collectors;

public class DebtMapper {

    public static Debt toDebt(DebtDto debtDto){
        Debt debt = new Debt();
        debt.setId(debtDto.getId());
        debt.setNote(debtDto.getNote());
        debt.setAdmin(debtDto.getAdmin());
        debt.setAmount(debtDto.getAmount());
        debt.setCreditor(debtDto.getCreditor());
        debt.setCurrency(debtDto.getCurrency());
        debt.setTypeOfDebt(debtDto.getTypeOfDebt());
        debt.setReturnDate(debtDto.getReturnDate());
        debt.setBorrowingDate(debtDto.getBorrowingDate());
        return debt;
    }

    public static DebtDto toDto(Debt debt){
        DebtDto debtDto = new DebtDto();
        debtDto.setId(debt.getId());
        debtDto.setNote(debt.getNote());
        debtDto.setAdmin(debt.getAdmin());
        debtDto.setAmount(debt.getAmount());
        debtDto.setCreditor(debt.getCreditor());
        debtDto.setCurrency(debt.getCurrency());
        debtDto.setTypeOfDebt(debt.getTypeOfDebt());
        debtDto.setReturnDate(debt.getReturnDate());

        debtDto.setBorrowingDate(debt.getBorrowingDate());
        return debtDto;
    }

    public static List<DebtDto> toDebtDtoList(List<Debt> debtList){
      return   debtList.stream()
              .map(DebtMapper::toDto)
              .collect(Collectors.toList());
    }

    public static List<Debt> toDebtList(List<DebtDto> debtDtoList){
      return   debtDtoList.stream()
              .map(DebtMapper::toDebt)
              .collect(Collectors.toList());
    }
}
