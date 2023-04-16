package com.epam.money_management.rest.service.impl;

import com.epam.money_management.model.dto.DebtRepaymentDto;
import com.epam.money_management.model.entity.Debt;
import com.epam.money_management.model.mapper.DebtMapper;
import com.epam.money_management.model.mapper.DebtRepaymentMapper;
import com.epam.money_management.rest.repository.DebtRepaymentRepository;
import com.epam.money_management.rest.service.DebtRepaymentService;
import com.epam.money_management.rest.service.DebtService;
import org.springframework.stereotype.Service;

@Service
public class DebtRepaymentServiceImpl implements DebtRepaymentService {

    private final DebtRepaymentRepository debtRepaymentRepository;
    private final DebtService debtService;

    public DebtRepaymentServiceImpl(DebtRepaymentRepository debtRepaymentRepository, DebtService debtService) {
        this.debtRepaymentRepository = debtRepaymentRepository;
        this.debtService = debtService;
    }

    @Override
    public void save(DebtRepaymentDto debtRepaymentDto) {
        Debt debt = DebtMapper.toDebt(debtService.findById(debtRepaymentDto.getDebtId()));
        debtRepaymentDto.setResidue(debt.getAmount() - debtRepaymentDto.getRepayment());
        debtService.updateResidue(debt.getId(), debtRepaymentDto.getResidue());
        debtRepaymentRepository.save(DebtRepaymentMapper.toDebtRepayment(debtRepaymentDto, debt));
    }
}
