package com.tenpisoft.n2w.internal;

public class ToStringConverter {
    public static GenderAwareIntegerToStringConverter toGenderAwareInteger(final IntegerToStringConverter integerToStringConverter) {
        return (value, genderType) -> integerToStringConverter.asWords(value);
    }
}
