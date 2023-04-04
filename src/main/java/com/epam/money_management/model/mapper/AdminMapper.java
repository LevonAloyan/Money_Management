package com.epam.money_management.model.mapper;

import com.epam.money_management.model.dto.AdminDto;
import com.epam.money_management.model.entity.Admin;

import java.util.List;
import java.util.stream.Collectors;

public class AdminMapper {
    public static Admin toAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setId(adminDto.getId());
        admin.setName(adminDto.getName());
        admin.setSurname(adminDto.getSurname());
        admin.setPhoneNumber(adminDto.getPhoneNumber());
        return admin;
    }

    public static AdminDto toDto(Admin admin) {
        AdminDto adminDto = new AdminDto();
        adminDto.setId(admin.getId());
        adminDto.setName(admin.getName());
        adminDto.setSurname(admin.getSurname());
        adminDto.setPhoneNumber(admin.getPhoneNumber());
        return adminDto;
    }

    public static List<Admin> toAdminList(List<AdminDto> adminDtoList) {
        return adminDtoList.stream().map(AdminMapper::toAdmin).collect(Collectors.toList());
    }

    public static List<AdminDto> toDtoList(List<Admin> adminList) {
        return adminList.stream().map(AdminMapper::toDto).collect(Collectors.toList());
    }
}
