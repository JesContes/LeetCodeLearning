package com.company.odlesson;

import org.junit.Test;

import static org.junit.Assert.*;

public class SodaBottleTest {

    @Test
    public void drinkSodaNumWhenNotRemainEmptyBottle() {
        int emptyBottle = 15;
        SodaBottle bottle = new SodaBottle();
        int result = bottle.drinkSodaNum(emptyBottle);
        assertEquals(7, result);
    }

    @Test
    public void drinkSodaNumWhenRemainEmptyBottle() {
        int emptyBottle = 16;
        SodaBottle bottle = new SodaBottle();
        int result = bottle.drinkSodaNum(emptyBottle);
        assertEquals(8, result);
    }

    @Test
    public void drinkSodaNumWhenCantDrink() {
        int emptyBottle = 1;
        SodaBottle bottle = new SodaBottle();
        int result = bottle.drinkSodaNum(emptyBottle);
        assertEquals(0, result);
    }
}