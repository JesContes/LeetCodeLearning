package com.company.odlesson;

import org.junit.Test;

import static org.junit.Assert.*;

public class Hexadecimal2DecimalTest {

    @Test
    public void convert() {
        String hex = "0xAA";
        Hexadecimal2Decimal decimal = new Hexadecimal2Decimal();
        int result = decimal.convert(hex);
        assertEquals(170, result);
    }
}