package com.tenpisoft.n2w.internal.languages.spanish;

import com.tenpisoft.n2w.internal.IntegerToStringConverter;
import com.tenpisoft.n2w.internal.MultiFormNumber;
import com.tenpisoft.n2w.internal.NumberProcessor;

import java.util.Map;

public class SpanishIntegerToWordsConverter implements IntegerToStringConverter {
    private final IntegerToStringConverter bigNumbersConverter;
    private final Map<Integer, MultiFormNumber> exceptions;
    private final IntegerToStringConverter smallNumbersConverter;

    public SpanishIntegerToWordsConverter(IntegerToStringConverter bigNumbersConverter,
                                          Map<Integer, MultiFormNumber> exceptions,
                                          IntegerToStringConverter smallNumbersConverter) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.exceptions = exceptions;
        this.smallNumbersConverter = smallNumbersConverter;
    }

    @Override
    public String asWords(Integer value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value).getAloneForm();
        }

        Integer bigNumber = value / 1000000;
        Integer smallNumber = value % 1000000;

        return new NumberProcessor(bigNumbersConverter, smallNumbersConverter).process(bigNumber, smallNumber);
    }
}
