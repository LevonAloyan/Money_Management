package com.epam.money_management.rest.service;

import com.epam.money_management.model.dto.CreditorDto;

import java.util.List;
import java.util.Set;

public interface CreditorService {

    List<CreditorDto> findAll();

    Set<CreditorDto> allLenders(Long adminId);

    Set<CreditorDto> allBorrowers(Long adminId);

    void save(CreditorDto creditorDto);
}
