package com.tenpisoft.n2w.internal;

import com.tenpisoft.n2w.internal.languages.GenderForms;
import com.tenpisoft.n2w.internal.languages.PluralForms;

import java.util.List;
import java.util.Map;

public interface BaseValues {
    Map<Integer, GenderForms> baseNumbers();

    List<PluralForms> pluralForms();

    String currency();

    char twoDigitsNumberSeparator();
}
