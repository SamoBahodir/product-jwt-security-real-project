package com.productexseption.calculator;

import com.productexseption.core.enumeration.CountType;
import com.productexseption.core.enumeration.CreditType;
import com.productexseption.core.enumeration.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculatorService {
    private final CalculatorUtil util;

    public List<CalculatorResponse> calculator(CalculatorRequest request, CountType countType, CreditType creditType,
                                               Currency currency) {

        if (countType.equals(CountType.ODDIY) && creditType.equals(CreditType.ONLINE_MICROLOAN)) {

            return util.oddiy(request.getBalance(), request.getMoon(), request.getPercentage(),
                    request.getInsuranceCosts(), request.getNotaryExpenses(), request.getAnotherExpenses());

        } else if (countType.equals(CountType.ANNUITET) && creditType.equals(CreditType.ONLINE_MICROLOAN)) {
            return util.annuitet(request.getBalance(), request.getMoon(), request.getPercentage(),
                    request.getInsuranceCosts(), request.getNotaryExpenses(), request.getAnotherExpenses());

        } else if (countType.equals(CountType.ODDIY) && creditType.equals(CreditType.FOR_BUSINESS_ENTITIES)) {
            return util.bisinessOddiy(request.getBalance(), request.getMoon(), request.getPercentage(),
                    request.getInsuranceCosts(), request.getNotaryExpenses(), request.getAnotherExpenses(), currency);

        } else if (countType.equals(CountType.ANNUITET) && creditType.equals(CreditType.FOR_BUSINESS_ENTITIES)) {
            return util.bisinessAnnuitet(request.getBalance(), request.getMoon(), request.getPercentage(),
                    request.getInsuranceCosts(), request.getNotaryExpenses(), request.getAnotherExpenses(), currency);
        }
        else return null;
    }
}
