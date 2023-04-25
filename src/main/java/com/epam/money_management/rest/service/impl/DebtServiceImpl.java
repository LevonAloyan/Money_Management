package com.epam.money_management.rest.service.impl;

import com.epam.money_management.constants.Type;
import com.epam.money_management.exceptions.ObjectIsNullException;
import com.epam.money_management.model.dto.DebtDto;
import com.epam.money_management.model.entity.Debt;
import com.epam.money_management.model.mapper.AdminMapper;
import com.epam.money_management.model.mapper.DebtMapper;
import com.epam.money_management.rest.controller.AdminController;
import com.epam.money_management.rest.repository.DebtRepository;
import com.epam.money_management.rest.service.AdminService;
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
    private final AdminService adminService;

    @Autowired
    public DebtServiceImpl(DebtRepository debtRepository, AdminService adminService) {
        this.debtRepository = debtRepository;
        this.adminService = adminService;
    }


    @Override
    public List<DebtDto> findAllByAdminId(Long adminId) {
        return DebtMapper.toDebtDtoList(debtRepository.findAllByAdmin_Id(adminId));
    }

    @Override
    public List<DebtDto> allLendersOrBorrowers(Long id, Type type) {
        return DebtMapper.toDebtDtoList(debtRepository.findAllByAdminIdAndTypeOfDebt(id, type));
    }

    @Override
    public void save(DebtDto debtDto, Long adminId) {
        debtDto.setAdmin(AdminMapper.toAdmin(adminService.findById(adminId)));
        logger.info("Found and added admin by id");
        debtRepository.save(DebtMapper.toDebt(debtDto));
        logger.info("Created new debt");
    }

    @Override
    public List<DebtDto> findByCreditorIdAdminIdAndTypeOfDebt(Long creditorId, Long adminId, Type type) {
        return DebtMapper.toDebtDtoList(debtRepository.findByCreditorIdAndAdminIdAndTypeOfDebt(creditorId, adminId, type));
    }

    @Override
    public DebtDto findById(Long id) {
        return DebtMapper.toDto(debtRepository.findById(id).orElseThrow(ObjectIsNullException::new));
    }

    @Override
    public void updateResidue(Long debtId, Long residue) {
        Debt debt = DebtMapper.toDebt(findById(debtId));
        debt.setResidue(residue);
       debtRepository.save(debt);
    }
}
