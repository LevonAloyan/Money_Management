package com.epam.money_management.rest.service;

import com.epam.money_management.constants.Type;
import com.epam.money_management.model.dto.DebtDto;

import java.util.List;

public interface DebtService {

    List<DebtDto> findAllByAdminId(Long adminId);

    List<DebtDto> allLendersOrBorrowers(Long adminId, Type type);

}
