package com.epam.money_management.rest.controller;

import com.epam.money_management.constants.Currency;
import com.epam.money_management.constants.Type;
import com.epam.money_management.model.dto.DebtDto;
import com.epam.money_management.rest.service.CreditorService;
import com.epam.money_management.rest.service.DebtService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static com.epam.money_management.constants.ControllerHelper.*;

@Controller
@RequestMapping()
public class AdminController {

    private final DebtService debtService;

    private final CreditorService creditorService;

    public AdminController(DebtService debtService, CreditorService creditorService) {
        this.debtService = debtService;
        this.creditorService = creditorService;
    }

    @GetMapping()
    public String open(Model model) {
        model.addAttribute("debt", new DebtDto());
        model.addAttribute("lenders", creditorService.allLenders());
        model.addAttribute("borrowers",creditorService.allBorrowers());
        model.addAttribute("currencies", Currency.values());
        model.addAttribute("typesOfDebt", Type.values());
        return HOME_HTML;
    }

    @PostMapping()
    public String saveDebt(@ModelAttribute("debt") @Valid DebtDto debtDto, BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            model.addAttribute("lenders", creditorService.allLenders());
            model.addAttribute("borrowers", creditorService.allBorrowers());
            model.addAttribute("currencies", Currency.values());
            model.addAttribute("typesOfDebt", Type.values());
            return HOME_HTML;
        }
        debtService.save(debtDto);
        return REDIRECT_HOME_HTML;
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
