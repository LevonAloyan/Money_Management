package com.epam.money_management.rest.service.impl;

import com.epam.money_management.constants.Type;
import com.epam.money_management.model.dto.DebtDto;
import com.epam.money_management.model.mapper.DebtMapper;
import com.epam.money_management.rest.controller.AdminController;
import com.epam.money_management.rest.repository.DebtRepository;
import com.epam.money_management.rest.service.DebtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebtServiceImpl implements DebtService {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    private final DebtRepository debtRepository;

    @Autowired
    public DebtServiceImpl(DebtRepository debtRepository) {
        this.debtRepository = debtRepository;
    }


    @Override
    public List<DebtDto> findAllByAdminId(Long adminId) {
        return DebtMapper.toDebtDtoList(debtRepository.findAllByAdmin_Id(adminId));

    }

    @Override
    public List<DebtDto> allLendersOrBorrowers(Long id, Type type) {
        return DebtMapper.toDebtDtoList(debtRepository.findAllByAdminIdAndTypeOfDebt(id,type));
    }

    @Override
    public void save(DebtDto debtDto) {
        debtRepository.save(DebtMapper.toDebt(debtDto));
    }

}
