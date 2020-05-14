package com.tenpisoft.n2w;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        MoneyConverters converter = MoneyConverters.SPANISH_BANKING_MONEY_VALUE;
        String moneyAsWords = converter.asWords(new BigDecimal("10.20"));
        System.out.println(moneyAsWords.toUpperCase());
    }

}