package com.tenpisoft.n2w.internal.converters
import com.tenpisoft.n2w.internal.GenderAwareIntegerToStringConverter
import com.tenpisoft.n2w.internal.languages.spanish.SpanishValues
import spock.lang.Specification

class IntegerToWordsConverterTest extends Specification {

    def hundredsToWordsConverter = Stub(GenderAwareIntegerToStringConverter)
    def converter = new IntegerToWordsConverter(hundredsToWordsConverter, new SpanishValues().pluralForms())

    def setup() {
        hundredsToWordsConverter.asWords(0, _) >> "cero"
        hundredsToWordsConverter.asWords(1, _) >> "uno"
        hundredsToWordsConverter.asWords(2, _) >> "dos"
        hundredsToWordsConverter.asWords(3, _) >> "tres"
    }

    def "should convert 0"() {
        expect:
        converter.asWords(0) == "cero"
    }

    def "should convert simply value"() {
        expect:
        converter.asWords(1) == "uno"
    }

    def "should convert complex value"() {
        expect:
        converter.asWords(1002003) == "un millon dos mil tres"
    }

    def "should throw IllegalArgumentException when hundredsToWordsConverter can't convert given value"() {
        given:
        hundredsToWordsConverter.asWords(4, _) >> { throw new IllegalArgumentException() }

        when:
        converter.asWords(1002004)

        then:
        thrown(IllegalArgumentException)
    }
}