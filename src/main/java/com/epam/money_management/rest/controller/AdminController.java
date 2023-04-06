package com.epam.money_management.rest.controller;

import com.epam.money_management.constants.Currency;
import com.epam.money_management.constants.Type;
import com.epam.money_management.model.dto.DebtDto;
import com.epam.money_management.rest.service.DebtService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.epam.money_management.constants.ControllerHelper.*;

@Controller
@RequestMapping("/home/")
public class AdminController {

    private final DebtService debtService;

    public AdminController(DebtService debtService) {
        this.debtService = debtService;
    }

    @GetMapping("{id}")
    public String open(@PathVariable("id") Long adminId, Model model) {
        model.addAttribute("debt", new DebtDto());
        model.addAttribute("lenders", debtService.allLendersOrBorrowers(adminId, Type.LENT));
        model.addAttribute("borrowers", debtService.allLendersOrBorrowers(adminId, Type.BORROWED));
        model.addAttribute("currencies", Currency.values());
        model.addAttribute("typesOfDebt", Type.values());
        return HOME_HTML;
    }

    @GetMapping("/history")
    public String historyPage() {
        return HISTORY_HTML;
    }

    @GetMapping("/contact")
    public String contactPage() {
        return CONTACT_HTML;
    }
}
