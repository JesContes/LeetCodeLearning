package com.company.odlesson;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinCarParkTest {

    @Test
    public void minCarPark() {
        MinCarPark minCarPark = new MinCarPark();
        int[] cars1 = new int[]{1,0,1};
        int result1 = minCarPark.minCarPark(cars1);
        assertEquals(2, result1);
        int[] cars2 = new int[]{1,0,0,0,0,1,1,1,1,0,1,1};
        int result2 = minCarPark.minCarPark(cars2);
        assertEquals(4, result2);
    }
}