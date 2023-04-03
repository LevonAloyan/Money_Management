package com.epam.money_management.rest.service;

import com.epam.money_management.constants.Type;
import com.epam.money_management.model.dto.DebtDto;

import java.util.List;

public interface DebtService {

    List<DebtDto> findAllByAdminId(Long adminId);

    List<DebtDto> allLenders(Long adminId, Type type);

}
