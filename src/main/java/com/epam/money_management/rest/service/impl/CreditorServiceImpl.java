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
    public List<CreditorDto> allLenders() {
        List<CreditorDto> lendersList = new ArrayList<>();
        List<DebtDto> debtsDto = debtService.allLendersOrBorrowers(1L, Type.LENT);
        if (!debtsDto.isEmpty()) {
            for (DebtDto debtDto : debtsDto) {
                lendersList.add(CreditorMapper.toDto(debtDto.getCreditor()));
            }
        }
        return lendersList;
    }

    @Override
    public List<CreditorDto> allBorrowers() {
        List<CreditorDto> borrowersList = new ArrayList<>();
        List<DebtDto> debtsDto = debtService.allLendersOrBorrowers(1L, Type.BORROWED);
        if (!debtsDto.isEmpty()) {
            for (DebtDto debtDto : debtsDto) {
                borrowersList.add(CreditorMapper.toDto(debtDto.getCreditor()));
            }
        }
        return borrowersList;
    }


}
