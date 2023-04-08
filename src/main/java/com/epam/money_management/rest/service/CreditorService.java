package com.epam.money_management.rest.service;

import com.epam.money_management.model.dto.CreditorDto;
import com.epam.money_management.model.entity.Creditor;

import java.util.List;

public interface CreditorService {

    List<CreditorDto> findAll();
    List<CreditorDto> allLenders(Long adminId);
    List<CreditorDto> allBorrowers(Long adminId);
}
