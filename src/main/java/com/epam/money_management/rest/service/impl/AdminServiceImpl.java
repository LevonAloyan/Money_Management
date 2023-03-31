package com.epam.money_management.rest.service.impl;

import com.epam.money_management.rest.controller.AdminController;
import com.epam.money_management.rest.repository.AdminRepository;
import com.epam.money_management.rest.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


}
