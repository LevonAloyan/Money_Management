package com.epam.money_management.rest.controller;

import com.epam.money_management.constants.Type;
import com.epam.money_management.model.dto.DebtDto;
import com.epam.money_management.rest.service.CreditorService;
import com.epam.money_management.rest.service.DebtService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/{adminId}/")
public class DebtController {
    private final DebtService debtService;
    private final CreditorService creditorService;

    public DebtController(DebtService debtService, CreditorService creditorService) {
        this.debtService = debtService;
        this.creditorService = creditorService;
    }

    @GetMapping("debt/{creditorId}")
    public String concreteCreditorBorrows(@PathVariable("adminId") Long adminId,
                                          @PathVariable("creditorId") Long creditorId, Model model) {

        List<DebtDto> allDebtsOdConcreteCreditor = new ArrayList<>();
        model.addAttribute("creditor", creditorService.findById(creditorId).getFullName());
        allDebtsOdConcreteCreditor.addAll(debtService.findByCreditorIdAdminIdAndTypeOfDebt(creditorId, adminId, Type.LENT));
        allDebtsOdConcreteCreditor.addAll(debtService.findByCreditorIdAdminIdAndTypeOfDebt(creditorId, adminId, Type.BORROWED));
        model.addAttribute("allDebtsOdConcreteCreditor", allDebtsOdConcreteCreditor);
        return "concreteDebts";
    }
}
