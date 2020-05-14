package com.tenpisoft.n2w.internal;

import com.tenpisoft.n2w.internal.languages.GenderType;

public interface GenderAwareIntegerToStringConverter {
    String asWords(Integer value, GenderType genderType);

}
