package com.epam.money_management.rest.service.impl;

import com.epam.money_management.model.dto.AdminDto;
import com.epam.money_management.model.entity.Admin;
import com.epam.money_management.model.mapper.AdminMapper;
import com.epam.money_management.rest.controller.AdminController;
import com.epam.money_management.rest.repository.AdminRepository;
import com.epam.money_management.rest.service.AdminService;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public AdminDto findById(Long id) {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()){
            logger.info("Admin with matching id found and returned");
            return AdminMapper.toDto(admin.get());
        }
        logger.error("Admin with matching id not found");
        throw new ObjectNotFoundException(id, "Admin with this id is not found");
    }
}
