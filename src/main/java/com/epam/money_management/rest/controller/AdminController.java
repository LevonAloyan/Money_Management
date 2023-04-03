package com.epam.money_management.rest.controller;

import com.epam.money_management.constants.Type;
import com.epam.money_management.model.dto.DebtDto;
import com.epam.money_management.rest.service.DebtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home/")
public class AdminController {

    private final DebtService debtService;

    public AdminController(DebtService debtService) {
        this.debtService = debtService;
    }

    @GetMapping("{id}")
    public ResponseEntity<List<DebtDto>> open(@PathVariable("id") Long adminId) {
        debtService.allLenders(adminId, Type.LENT);
        debtService.allLenders(adminId, Type.BORROWED);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
