package com.productexseption.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculatorService {
    private final CalculatorUtil util;

    public List<CalculatorResponse> calculator(CalculatorRequest request, CountType countType, CreditType creditType) {

        if (countType.equals(CountType.ODDIY) && creditType.equals(CreditType.ONLINE_MICROLOAN)) {

            return util.oddiy(request.getBalance(), request.getMoon(), request.getPercentage(),
                    request.getInsuranceCosts(), request.getNotaryExpenses(), request.getAnotherExpenses());

        } else return util.annuitet(request.getBalance(), request.getMoon(), request.getPercentage(),
                request.getInsuranceCosts(), request.getNotaryExpenses(), request.getAnotherExpenses());
    }
}
