package com.tenpisoft.n2w;

import com.tenpisoft.n2w.internal.BigDecimalToStringConverter;
import static com.google.common.base.Verify.verifyNotNull;
import static com.tenpisoft.n2w.internal.Container.spanishContainer;

import java.math.BigDecimal;

public enum MoneyConverters {
    SPANISH_BANKING_MONEY_VALUE(spanishContainer().getBankingMoneyConverter());

    private final BigDecimalToStringConverter converter;

    MoneyConverters(BigDecimalToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(BigDecimal value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }

    public static BigDecimalToStringConverter customSpanishContainer(String currency) {
        return spanishContainer(currency).getBankingMoneyConverter();
    }
}
