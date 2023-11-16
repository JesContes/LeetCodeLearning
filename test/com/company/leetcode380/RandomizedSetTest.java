package com.company.leetcode380;

import org.junit.Test;

public class RandomizedSetTest {
    @Test
    public void randomizedSetTest1() {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        randomizedSet.getRandom();
    }
}