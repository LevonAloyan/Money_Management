package com.epam.money_management.rest.service.impl;

import com.epam.money_management.constants.Type;
import com.epam.money_management.model.dto.CreditorDto;
import com.epam.money_management.model.dto.DebtDto;
import com.epam.money_management.model.entity.Creditor;
import com.epam.money_management.model.mapper.CreditorMapper;
import com.epam.money_management.rest.repository.CreditorRepository;
import com.epam.money_management.rest.service.CreditorService;
import com.epam.money_management.rest.service.DebtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditorServiceImpl implements CreditorService {

    private final CreditorRepository creditorRepository;
    private final DebtService debtService;
    private static final Logger logger = LoggerFactory.getLogger(Creditor.class);


    @Autowired
    public CreditorServiceImpl(CreditorRepository creditorRepository, DebtService debtService) {
        this.creditorRepository = creditorRepository;
        this.debtService = debtService;
    }

    @Override
    public List<CreditorDto> findAll() {
        return CreditorMapper.toDtoList(creditorRepository.findAll());
    }

    @Override
    public List<CreditorDto> allLenders(Long adminId) {
        List<CreditorDto> lendersList = new ArrayList<>();
        List<DebtDto> debtsDto = debtService.allLendersOrBorrowers(adminId, Type.LENT);
        logger.info("Found all debts with lent status");
        if (!debtsDto.isEmpty()) {
            for (DebtDto debtDto : debtsDto) {
                lendersList.add(CreditorMapper.toDto(debtDto.getCreditor()));
            }
            logger.info("Added to list all creditors at debt with lent status");
        }
        return lendersList;
    }

    @Override
    public List<CreditorDto> allBorrowers(Long adminId) {
        List<CreditorDto> borrowersList = new ArrayList<>();
        List<DebtDto> debtsDto = debtService.allLendersOrBorrowers(adminId, Type.BORROWED);
        logger.info("Found all debts with borrowed status");
        if (!debtsDto.isEmpty()) {
            for (DebtDto debtDto : debtsDto) {
                borrowersList.add(CreditorMapper.toDto(debtDto.getCreditor()));
            }
            logger.info("Added to list all creditors at debt with borrowed status");
        }
        return borrowersList;
    }


}
