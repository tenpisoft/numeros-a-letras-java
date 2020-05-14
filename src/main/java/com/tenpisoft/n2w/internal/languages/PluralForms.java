package com.tenpisoft.n2w.internal.languages;

public interface PluralForms {
    String formFor(Integer value);
    GenderType genderType();
}
