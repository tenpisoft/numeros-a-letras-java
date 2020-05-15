package com.tenpisoft.n2w

import com.google.common.base.VerifyException
import spock.lang.Specification

import static com.tenpisoft.n2w.MoneyConverters.SPANISH_BANKING_MONEY_VALUE

class MoneyConvertersTest extends Specification {

    def "should convert money in Spanish"() {
        expect:
        SPANISH_BANKING_MONEY_VALUE.asWords(1_234.56) == "mil doscientos treinta y cuatro \$ CON 56/100"
        
    }

}