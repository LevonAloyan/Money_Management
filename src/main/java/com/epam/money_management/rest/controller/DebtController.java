package com.epam.money_management.rest.controller;

import com.epam.money_management.constants.Type;
import com.epam.money_management.model.dto.DebtDto;
import com.epam.money_management.model.dto.DebtRepaymentDto;
import com.epam.money_management.rest.service.CreditorService;
import com.epam.money_management.rest.service.DebtRepaymentService;
import com.epam.money_management.rest.service.DebtService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.epam.money_management.constants.ControllerHelper.CONCRETE_CREDITOR_DEBTS_HTML;
import static com.epam.money_management.constants.ControllerHelper.REDIRECT_TO_HTML;

@Controller
@RequestMapping("/{adminId}/")
public class DebtController {
    private final DebtService debtService;
    private final CreditorService creditorService;
    private final DebtRepaymentService debtRepaymentService;

    public DebtController(DebtService debtService, CreditorService creditorService, DebtRepaymentService debtRepaymentService) {
        this.debtService = debtService;
        this.creditorService = creditorService;
        this.debtRepaymentService = debtRepaymentService;
    }

    @GetMapping("debt/{creditorId}")
    public String concreteCreditorBorrows(@PathVariable("adminId") Long adminId,
                                          @PathVariable("creditorId") Long creditorId, Model model) {

        List<DebtDto> allDebtsOdConcreteCreditor = new ArrayList<>();
        allDebtsOdConcreteCreditor.addAll(debtService.findByCreditorIdAdminIdAndTypeOfDebt(creditorId, adminId, Type.LENT));
        allDebtsOdConcreteCreditor.addAll(debtService.findByCreditorIdAdminIdAndTypeOfDebt(creditorId, adminId, Type.BORROWED));
        model.addAttribute("creditor", creditorService.findById(creditorId).getFullName());
        model.addAttribute("allDebtsOdConcreteCreditor", allDebtsOdConcreteCreditor);
        model.addAttribute("repayment", new DebtRepaymentDto());
        return CONCRETE_CREDITOR_DEBTS_HTML;
    }

    @PostMapping("debt/{creditorId}")
    public String repayment(@ModelAttribute("repayment") @Valid DebtRepaymentDto debtRepaymentDto, BindingResult result,
                            @PathVariable("adminId") Long adminId, @PathVariable("creditorId") Long creditorId,
                            Model model) {
        if (result.hasErrors()) {
            List<DebtDto> allDebtsOdConcreteCreditor = new ArrayList<>();
            allDebtsOdConcreteCreditor.addAll(debtService.findByCreditorIdAdminIdAndTypeOfDebt(creditorId, adminId, Type.LENT));
            allDebtsOdConcreteCreditor.addAll(debtService.findByCreditorIdAdminIdAndTypeOfDebt(creditorId, adminId, Type.BORROWED));
            model.addAttribute("creditor", creditorService.findById(creditorId).getFullName());
            model.addAttribute("allDebtsOdConcreteCreditor", allDebtsOdConcreteCreditor);
            return "creditorCreation";
        }
        debtRepaymentService.save(debtRepaymentDto);

        return REDIRECT_TO_HTML + adminId + "/debt/" + creditorId;
    }
}
