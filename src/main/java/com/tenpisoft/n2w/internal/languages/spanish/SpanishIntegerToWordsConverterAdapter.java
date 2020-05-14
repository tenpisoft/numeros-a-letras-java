package com.tenpisoft.n2w.internal.languages.spanish;

import com.tenpisoft.n2w.internal.IntegerToStringConverter;
import com.tenpisoft.n2w.internal.converters.IntegerToWordsConverter;
import com.tenpisoft.n2w.internal.languages.GenderType;
import com.tenpisoft.n2w.internal.languages.PluralForms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpanishIntegerToWordsConverterAdapter extends IntegerToWordsConverter {
    public SpanishIntegerToWordsConverterAdapter(IntegerToStringConverter hundredsToWordsConverter,
                                                 List<PluralForms> pluralForms) {
        super(hundredsToWordsConverter, pluralForms);
    }

    @Override
    protected String joinValueChunksWithForms(Iterator<Integer> chunks, Iterator<PluralForms> formsToUse) {
        List<String> result = new ArrayList<>();

        while (chunks.hasNext() && formsToUse.hasNext()) {
            Integer currentChunkValue = chunks.next();
            PluralForms currentForms = formsToUse.next();

            if (currentChunkValue > 0) {
                result.add(hundredsToWordsConverter.asWords(currentChunkValue, GenderType.NON_APPLICABLE));
                result.add(currentForms.formFor(currentChunkValue));
            }
        }

        return joinParts(result);
    }

}
