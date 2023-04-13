package com.epam.money_management.rest.controller;

import com.epam.money_management.constants.Type;
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

    public DebtController(DebtService debtService) {
        this.debtService = debtService;
    }

    @GetMapping("borrowed/{creditorId}")
    public String concreteCreditorBorrows(@PathVariable("adminId") Long adminId,
                                          @PathVariable("creditorId") Long creditorId, Model model) {

        model.addAttribute("concreteCreditorBorrows",
                debtService.findByCreditorIdAdminIdAndTypeOfDebt(creditorId, adminId, Type.BORROWED));
        return "concreteBorrows";
    }
    @GetMapping("lent/{creditorId}")
    public String concreteCreditorLents(@PathVariable("adminId") Long adminId,
                              @PathVariable("creditorId") Long creditorId, Model model) {

        model.addAttribute("concreteCreditorLents",
                debtService.findByCreditorIdAdminIdAndTypeOfDebt(creditorId, adminId, Type.LENT));
        return "concreteLents";
    }
}
