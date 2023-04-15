package com.productexseption.controller;

import com.productexseption.calculator.*;
import com.productexseption.config.SwaggerConfig;
import com.productexseption.core.enumeration.CountType;
import com.productexseption.core.enumeration.CreditType;
import com.productexseption.core.enumeration.Currency;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bank")
@SecurityRequirement(name = SwaggerConfig.BEARER)
public class CalculatorController {
    private final CalculatorService service;

    @PostMapping("/calculator")
    public List<CalculatorResponse> calculator(@RequestBody CalculatorRequest request,
                                               @RequestParam CountType countType,
                                               @RequestParam CreditType creditType,
                                               @RequestParam(required = false) Currency currency) {
        return service.calculator(request, countType ,creditType,currency);

    }
}
