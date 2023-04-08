package com.epam.money_management.rest.controller;

import com.epam.money_management.model.dto.CreditorDto;
import com.epam.money_management.rest.service.CreditorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.epam.money_management.constants.ControllerHelper.CREDITOR_CREATION_HTML;
import static com.epam.money_management.constants.ControllerHelper.REDIRECT_TO_HTML;

@Controller
@RequestMapping("{adminId}/creditor")
public class CreditorController {

    private final CreditorService creditorService;

    public CreditorController(CreditorService creditorService) {
        this.creditorService = creditorService;
    }

    @GetMapping()
    public String open(@PathVariable("adminId") Long adminId, Model model) {
        model.addAttribute("creditor", new CreditorDto());
        model.addAttribute("adminId", adminId);
        return CREDITOR_CREATION_HTML;
    }

    @PostMapping()
    public String saveCreditor(@ModelAttribute("creditor") @Valid CreditorDto creditorDto, BindingResult result,
                               @PathVariable("adminId") Long adminId, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("adminId", adminId);
            return "creditorCreation";
        }
        creditorService.save(creditorDto);
        return REDIRECT_TO_HTML + adminId + "/creditor";
    }
}
