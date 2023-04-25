package com.epam.money_management.rest.repository;

import com.epam.money_management.model.entity.DebtRepayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtRepaymentRepository extends JpaRepository<DebtRepayment, Long> {

}
