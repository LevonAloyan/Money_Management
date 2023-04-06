package com.epam.money_management.rest.service.impl;

import com.epam.money_management.model.dto.CreditorDto;
import com.epam.money_management.model.entity.Creditor;
import com.epam.money_management.model.mapper.CreditorMapper;
import com.epam.money_management.rest.repository.CreditorRepository;
import com.epam.money_management.rest.service.CreditorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CreditorServiceImpl implements CreditorService {

    private final CreditorRepository creditorRepository;
    private static final Logger logger = LoggerFactory.getLogger(Creditor.class);


    @Autowired
    public CreditorServiceImpl(CreditorRepository creditorRepository) {
        this.creditorRepository = creditorRepository;
    }

    @Override
    public List<CreditorDto> findAll() {
        return CreditorMapper.toDtoList(creditorRepository.findAll());
    }
}
