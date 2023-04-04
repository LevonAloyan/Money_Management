package com.epam.money_management.model.mapper;

import com.epam.money_management.model.dto.CreditorDto;
import com.epam.money_management.model.entity.Creditor;

import java.util.List;
import java.util.stream.Collectors;

public class CreditorMapper {

    public static Creditor toCreditor(CreditorDto creditorDto) {
        Creditor creditor = new Creditor();
        creditor.setId(creditorDto.getId());
        creditor.setName(creditorDto.getName());
        creditor.setSurname(creditor.getSurname());
        creditor.setPhoneNumber(creditor.getPhoneNumber());
        return creditor;
    }

    public static CreditorDto toDto(Creditor creditor) {
        CreditorDto creditorDto = new CreditorDto();
        creditorDto.setId(creditor.getId());
        creditorDto.setName(creditor.getName());
        creditorDto.setSurname(creditor.getSurname());
        creditorDto.setPhoneNumber(creditor.getPhoneNumber());
        return creditorDto;
    }

    public static List<Creditor> toCreditorList(List<CreditorDto> creditorDtoList) {
        return creditorDtoList.stream().map(CreditorMapper::toCreditor).collect(Collectors.toList());
    }

    public static List<CreditorDto> toDtoList(List<Creditor> creditorList) {
        return creditorList.stream().map(CreditorMapper::toDto).collect(Collectors.toList());
    }

}
