package com.epam.money_management.rest.service.impl;

import com.epam.money_management.rest.controller.AdminController;
import com.epam.money_management.rest.repository.DebtRepository;
import com.epam.money_management.rest.service.DebtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DebtServiceImpl implements DebtService {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    private final DebtRepository debtRepository;

    @Autowired
    public DebtServiceImpl(DebtRepository debtRepository) {
        this.debtRepository = debtRepository;
    }

}
