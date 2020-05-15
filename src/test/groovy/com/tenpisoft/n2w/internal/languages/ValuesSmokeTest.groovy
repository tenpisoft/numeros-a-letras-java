package com.tenpisoft.n2w.internal.languages

import com.tenpisoft.n2w.ValueConverters
import spock.lang.Specification
import spock.lang.Unroll

class ValuesSmokeTest extends Specification {

    @Unroll
    def "should convert any value in range of 0-999 using #converter converter"() {
        expect:
        (0..999).each {
            assert converter.asWords(it).length() > 0
        }

        where:
        converter << ValueConverters.values()
    }
}