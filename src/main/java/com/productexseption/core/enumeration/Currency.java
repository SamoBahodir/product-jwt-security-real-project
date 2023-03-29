package com.productexseption.core.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Currency {
    UZS(860),
    USD(840),
    EUR(978);

    private final int id;

    public static Currency get(int id){
        for (Currency currency : values()){
            if (currency.getId() == id)
                return currency;
        }

        return null;
    }
}
