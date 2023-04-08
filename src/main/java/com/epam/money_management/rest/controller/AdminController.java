package com.epam.money_management.rest.controller;

import com.epam.money_management.constants.Currency;
import com.epam.money_management.constants.Type;
import com.epam.money_management.model.dto.DebtDto;
import com.epam.money_management.rest.service.CreditorService;
import com.epam.money_management.rest.service.DebtService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.epam.money_management.constants.ControllerHelper.*;

@Controller
@RequestMapping("/{adminId}")
public class AdminController {

    private final DebtService debtService;
    private final CreditorService creditorService;

    public AdminController(DebtService debtService, CreditorService creditorService) {
        this.debtService = debtService;
        this.creditorService = creditorService;
    }

    @GetMapping()
    public String open(@PathVariable("adminId") Long adminId, Model model) {
        model.addAttribute("debt", new DebtDto());
        return sendToFrontNecessaryFieldsForPopup(adminId, model);
    }

    @PostMapping()
    public String saveDebt(@ModelAttribute("debt") @Valid DebtDto debt, BindingResult result,
                           @PathVariable("adminId") Long adminId, Model model) {
        if (result.hasErrors()) {
            return sendToFrontNecessaryFieldsForPopup(adminId, model);
        }
        debtService.save(debt, adminId);
        return REDIRECT_HOME_HTML + adminId;
    }

    @GetMapping("/history")
    public String historyPage() {
        return HISTORY_HTML;
    }

    @GetMapping("/contact")
    public String contactPage() {
        return CONTACT_HTML;
    }

    private String sendToFrontNecessaryFieldsForPopup(Long adminId, Model model) {
        model.addAttribute("adminId", adminId);
        model.addAttribute("typesOfDebt", Type.values());
        model.addAttribute("currencies", Currency.values());
        model.addAttribute("creditors", creditorService.findAll());
        model.addAttribute("lenders", creditorService.allLenders(adminId));
        model.addAttribute("borrowers", creditorService.allBorrowers(adminId));
        return HOME_HTML;
    }
}
