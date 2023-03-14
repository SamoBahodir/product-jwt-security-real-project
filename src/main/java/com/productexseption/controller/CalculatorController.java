package com.productexseption.controller;

import com.productexseption.calculator.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bank")
public class CalculatorController {
    private final CalculatorService service;

    @PostMapping("/calculator")
    public List<CalculatorResponse> calculator(@RequestBody CalculatorRequest request,
                                               @RequestParam CountType countType,
                                               @RequestParam CreditType creditType) {
        return service.calculator(request, countType ,creditType);

    }
}
