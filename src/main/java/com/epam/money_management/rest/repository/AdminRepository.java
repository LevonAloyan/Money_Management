package com.epam.money_management.rest.repository;

import com.epam.money_management.model.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Administrator,Long> {
}
