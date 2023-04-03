package com.epam.money_management.rest.repository;

import com.epam.money_management.constants.Type;
import com.epam.money_management.model.dto.DebtDto;
import com.epam.money_management.model.entity.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Long> {
    List<Debt> findAllByAdmin_Id(Long adminId);

    List<Debt> findAllByAdminIdAndTypeOfDebt(Long adminId, Type type);

}
