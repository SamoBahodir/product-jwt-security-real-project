package com.productexseption.calculator;

import com.productexseption.core.enumeration.Currency;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorUtil {
    public List<CalculatorResponse> oddiy(double balance,
                                          double moon,
                                          double percentage,
                                          double insuranceCosts,
                                          double notaryExpenses,
                                          double anotherExpenses) {
        List<CalculatorResponse> responses = new ArrayList<>();
        double asosiyQarz;
        double oylikKridit = balance / moon;
        for (int i = 0; i < moon; i++) {
            double percentage1 = balance * percentage / 12 / 100;
            CalculatorResponse response = new CalculatorResponse();
            response.setBalance(String.format("%.2f", balance)); //balance
            asosiyQarz = oylikKridit;
            response.setPercentage(String.format("%.2f", percentage1));  //foiz
            response.setPrincipalDebt(String.format("%.2f", asosiyQarz));  //asosiy qarz
            response.setTotalMonthlyPayment(String.format("%.2f", asosiyQarz = asosiyQarz + percentage1));//tolov
            response.setAnotherExpenses(String.format("%.2f", anotherExpenses));
            response.setCommissionFee(String.format("%.2f", notaryExpenses));
            response.setPersonalExpenses(String.format("%.2f", insuranceCosts));
            balance = balance - oylikKridit;
            response.setMoon(i + 1);
            responses.add(response);
        }
        return responses;
    }

    public List<CalculatorResponse> annuitet(double balance,
                                             double moon,
                                             double percentage,
                                             double insuranceCosts,
                                             double notaryExpenses,
                                             double anotherExpenses) {
        double i = percentage / 12 / 100;
        double d = i * Math.pow(1 + i, moon);
        double d1 = Math.pow(1 + i, moon) - 1;
        double m = balance * d / d1;
        List<CalculatorResponse> responses = new ArrayList<>();
        for (int j = 0; j < moon; j++) {
            CalculatorResponse response = new CalculatorResponse();
            double percentage1 = balance * percentage / 12 / 100;
            response.setBalance(String.format("%.2f", balance));
            double a = (m - percentage1);
            response.setPrincipalDebt(String.format("%.2f", a));
            response.setPercentage(String.format("%.2f", percentage1));  //foiz
            response.setTotalMonthlyPayment(String.format("%.2f", m));  //oylik tolov
            response.setAnotherExpenses(String.format("%.2f", anotherExpenses));
            response.setCommissionFee(String.format("%.2f", notaryExpenses));
            response.setPersonalExpenses(String.format("%.2f", insuranceCosts));
            response.setMoon(j + 1);
            balance = balance - (m - percentage1);
            responses.add(response);
        }
        return responses;
    }

    public List<CalculatorResponse> bisinessAnnuitet(double balance,
                                                     double moon,
                                                     double percentage,
                                                     double insuranceCosts,
                                                     double notaryExpenses,
                                                     double anotherExpenses,
                                                     Currency currency) {

        double i = percentage / moon / 100;
        double d = i * Math.pow(1 + i, moon);
        double d1 = Math.pow(1 + i, moon) - 1;
        double m = balance * d / d1;
        List<CalculatorResponse> responses = new ArrayList<>();
        for (int j = 0; j < moon; j++) {
            CalculatorResponse response = new CalculatorResponse();
            double percentage1 = balance * percentage / 1000;
            response.setBalance(String.format("%.2f", balance));
            double a = (m - percentage1);
            response.setPrincipalDebt(String.format("%.2f", a));
            response.setPercentage(String.format("%.2f", percentage1));
            response.setTotalMonthlyPayment(String.format("%.2f", m));
            response.setAnotherExpenses(String.format("%.2f", anotherExpenses));
            response.setCommissionFee(String.format("%.2f", notaryExpenses));
            response.setPersonalExpenses(String.format("%.2f", insuranceCosts));
            response.setMoon(j + 1);
            balance = balance - (m - percentage1);
            responses.add(response);
        }
        return responses;
    }

    public List<CalculatorResponse> bisinessOddiy(double balance,
                                                  double moon,
                                                  double percentage,
                                                  double insuranceCosts,
                                                  double notaryExpenses,
                                                  double anotherExpenses,
                                                  Currency currency) {
        List<CalculatorResponse> responses = new ArrayList<>();
        double a = (balance / moon);
        for (int j = 0; j < moon; j++) {
            double percentage1 = balance * percentage / moon;
            CalculatorResponse response = new CalculatorResponse();
            response.setBalance(String.format("%.2f", balance));
            response.setPrincipalDebt(String.format("%.2f", a));
            response.setPercentage(String.format("%.2f", percentage1));
            response.setTotalMonthlyPayment(String.format("%.2f", a + percentage1));
            response.setAnotherExpenses(String.format("%.2f", anotherExpenses));
            response.setCommissionFee(String.format("%.2f", notaryExpenses));
            response.setPersonalExpenses(String.format("%.2f", insuranceCosts));
            response.setMoon(j + 1);
            balance = balance - a;
            responses.add(response);
        }
        return responses;
    }
}
