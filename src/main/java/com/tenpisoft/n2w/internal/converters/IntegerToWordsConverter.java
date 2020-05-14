package com.tenpisoft.n2w.internal.converters;

import com.tenpisoft.n2w.internal.GenderAwareIntegerToStringConverter;
import com.tenpisoft.n2w.internal.IntegerToStringConverter;
import com.tenpisoft.n2w.internal.ToStringConverter;
import com.tenpisoft.n2w.internal.languages.PluralForms;
import com.tenpisoft.n2w.internal.support.NumberChunking;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Lists.reverse;
import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class IntegerToWordsConverter implements IntegerToStringConverter {
    private final NumberChunking numberChunking = new NumberChunking();

    protected final GenderAwareIntegerToStringConverter hundredsToWordsConverter;
    private final List<PluralForms> pluralForms;

    public IntegerToWordsConverter(GenderAwareIntegerToStringConverter hundredsToWordsConverter,
                                   List<PluralForms> pluralForms) {
        this.hundredsToWordsConverter = hundredsToWordsConverter;
        this.pluralForms = pluralForms;
    }

    public IntegerToWordsConverter(final IntegerToStringConverter hundredsToWordsConverter,
                                   List<PluralForms> pluralForms) {
        this.hundredsToWordsConverter = ToStringConverter.toGenderAwareInteger(hundredsToWordsConverter);
        this.pluralForms = pluralForms;
    }

    @Override
    public String asWords(Integer value) {
        checkArgument(value >= 0, "can't convert negative numbers for value %d", value);

        List<Integer> valueChunks = numberChunking.chunk(value);
        List<PluralForms> formsToUse = reverse(pluralForms.subList(0, valueChunks.size()));

        return joinValueChunksWithForms(valueChunks.iterator(), formsToUse.iterator());
    }

    protected String joinValueChunksWithForms(Iterator<Integer> chunks, Iterator<PluralForms> formsToUse) {
        List<String> result = new ArrayList<>();

        while (chunks.hasNext() && formsToUse.hasNext()) {
            Integer currentChunkValue = chunks.next();
            PluralForms currentForms = formsToUse.next();

            if (currentChunkValue > 0) {
                result.add(hundredsToWordsConverter.asWords(currentChunkValue, currentForms.genderType()));
                result.add(currentForms.formFor(currentChunkValue));
            }
        }

        return joinParts(result);
    }

    protected String joinParts(List<String> result) {
        if (result.size() == 0) {
            return hundredsToWordsConverter.asWords(0, pluralForms.get(0).genderType());
        }

        return Joiner.on(" ").join(result).trim();
    }

}
