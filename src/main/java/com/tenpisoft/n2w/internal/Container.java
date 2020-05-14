package com.tenpisoft.n2w.internal;

import com.tenpisoft.n2w.internal.converters.BigDecimalToBankingMoneyConverter;
import com.tenpisoft.n2w.internal.converters.HundredsToWordsConverter;
import com.tenpisoft.n2w.internal.converters.IntegerToWordsConverter;
import com.tenpisoft.n2w.internal.languages.spanish.SpanishIntegerToWordsConverter;
import com.tenpisoft.n2w.internal.languages.spanish.SpanishIntegerToWordsConverterAdapter;
import com.tenpisoft.n2w.internal.languages.spanish.SpanishThousandToWordsConverter;
import com.tenpisoft.n2w.internal.languages.spanish.SpanishValues;

public final class Container {
    public static Container spanishContainer(String... currency) {
        SpanishValues values = new SpanishValues();

        String defaultCurrency = null;
        if (currency != null && currency.length == 1) {
            defaultCurrency = currency[0];
        } else {
            defaultCurrency = values.currency();
        }

        SpanishThousandToWordsConverter spanishThousandToWordsConverter = new SpanishThousandToWordsConverter(
                values.baseNumbers(), values.exceptions());

        IntegerToStringConverter converter = new SpanishIntegerToWordsConverter(
                new SpanishIntegerToWordsConverterAdapter(spanishThousandToWordsConverter, values.pluralForms()),
                values.exceptions(), spanishThousandToWordsConverter);

        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(
                converter, defaultCurrency);

        return new Container(converter, bigDecimalBankingMoneyValueConverter);
    }
    private final IntegerToStringConverter integerConverter;
    private final BigDecimalToStringConverter bigDecimalConverter;

    private Container(BaseValues baseValues) {
        HundredsToWordsConverter hundredsToStringConverter = new HundredsToWordsConverter(baseValues.baseNumbers(),
                baseValues.twoDigitsNumberSeparator());

        integerConverter = new IntegerToWordsConverter(
                hundredsToStringConverter,
                baseValues.pluralForms());
        bigDecimalConverter = new BigDecimalToBankingMoneyConverter(
                integerConverter,
                baseValues.currency());
    }

    private Container(IntegerToStringConverter integerConverter,
                      BigDecimalToStringConverter bigDecimalConverter) {
        this.integerConverter = integerConverter;
        this.bigDecimalConverter = bigDecimalConverter;
    }

    public IntegerToStringConverter getNumbersConverter() {
        return integerConverter;
    }

    public BigDecimalToStringConverter getBankingMoneyConverter() {
        return bigDecimalConverter;
    }
}
