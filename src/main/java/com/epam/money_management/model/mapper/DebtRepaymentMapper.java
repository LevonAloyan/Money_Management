package com.epam.money_management.model.mapper;

import com.epam.money_management.model.dto.DebtDto;
import com.epam.money_management.model.dto.DebtRepaymentDto;
import com.epam.money_management.model.entity.Debt;
import com.epam.money_management.model.entity.DebtRepayment;

import java.util.List;
import java.util.stream.Collectors;

public class DebtRepaymentMapper {

    public static DebtRepayment toDebtRepayment(DebtRepaymentDto debtRepaymentDto, Debt debt){
        DebtRepayment debtRepayment = new DebtRepayment();
        debtRepayment.setId(debtRepaymentDto.getId());
        debtRepayment.setResidue(debtRepaymentDto.getResidue());
        debtRepayment.setDebt(debt);
        debtRepayment.setRepayment(debtRepaymentDto.getRepayment());
        debtRepayment.setRepaymentDate(debtRepaymentDto.getRepaymentDate());
        return debtRepayment;
    }

    public static DebtRepaymentDto toDto(DebtRepayment debtRepayment){
        DebtRepaymentDto debtRepaymentDto = new DebtRepaymentDto();
        debtRepaymentDto.setId(debtRepayment.getId());
        debtRepaymentDto.setResidue(debtRepayment.getResidue());
        debtRepaymentDto.setDebtId(debtRepayment.getDebt().getId());
        debtRepaymentDto.setRepayment(debtRepayment.getRepayment());
        debtRepaymentDto.setRepaymentDate(debtRepayment.getRepaymentDate());
        return debtRepaymentDto;
    }

    public static List<DebtRepaymentDto> toDebtRepaymentDtoList(List<DebtRepayment> debtRepaymentList){
        return   debtRepaymentList.stream()
                .map(DebtRepaymentMapper::toDto)
                .collect(Collectors.toList());
    }

}
