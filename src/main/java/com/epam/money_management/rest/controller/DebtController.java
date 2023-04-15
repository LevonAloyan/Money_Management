package com.epam.money_management.rest.controller;

import com.epam.money_management.constants.Type;
import com.epam.money_management.rest.service.CreditorService;
import com.epam.money_management.rest.service.DebtService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{adminId}/")
public class DebtController {
    private final DebtService debtService;
    private final CreditorService creditorService;
    public DebtController(DebtService debtService, CreditorService creditorService) {
        this.debtService = debtService;
        this.creditorService = creditorService;
    }

    @GetMapping("borrowed/{creditorId}")
    public String concreteCreditorBorrows(@PathVariable("adminId") Long adminId,
                                          @PathVariable("creditorId") Long creditorId, Model model) {

        model.addAttribute("concreteCreditorBorrows",
                debtService.findByCreditorIdAdminIdAndTypeOfDebt(creditorId, adminId, Type.BORROWED));
        model.addAttribute("type", "BORROWED");
        model.addAttribute("creditor", creditorService.findById(creditorId).getFullName());
        return "concreteBorrows";
    }
    @GetMapping("lent/{creditorId}")
    public String concreteCreditorLents(@PathVariable("adminId") Long adminId,
                              @PathVariable("creditorId") Long creditorId, Model model) {

        model.addAttribute("concreteCreditorLents",
                debtService.findByCreditorIdAdminIdAndTypeOfDebt(creditorId, adminId, Type.LENT));
        model.addAttribute("type", "LENT");
        model.addAttribute("creditor", creditorService.findById(creditorId).getFullName());
        return "concreteLents";
    }
}
