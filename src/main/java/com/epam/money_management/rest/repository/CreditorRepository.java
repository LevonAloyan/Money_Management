package com.epam.money_management.rest.repository;

import com.epam.money_management.model.entity.Creditor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditorRepository extends JpaRepository<Creditor,Long> {
}
