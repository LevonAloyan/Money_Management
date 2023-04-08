package com.epam.money_management.rest.service;

import com.epam.money_management.model.dto.AdminDto;

public interface AdminService {

    AdminDto findById(Long id);
}
