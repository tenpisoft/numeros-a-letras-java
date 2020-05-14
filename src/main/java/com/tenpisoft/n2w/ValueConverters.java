package com.tenpisoft.n2w;

import com.tenpisoft.n2w.internal.IntegerToStringConverter;

import static com.tenpisoft.n2w.internal.Container.spanishContainer;
import static com.google.common.base.Verify.verifyNotNull;

public enum ValueConverters {
    SPANISH_INTEGER(spanishContainer().getNumbersConverter());

    private final IntegerToStringConverter converter;

    ValueConverters(IntegerToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Integer value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }
}
