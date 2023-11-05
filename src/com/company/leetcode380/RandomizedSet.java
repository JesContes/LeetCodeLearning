package com.company.leetcode380;

import java.util.*;

/**
 * @author awmlk
 */
public class RandomizedSet {
    private Random random;

    private final Map<Integer, Integer> valueIndex;

    private final List<Integer> values;

    public RandomizedSet() {
        valueIndex = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (values.contains(val)) {
            return false;
        }
        values.add(val);
        valueIndex.put(val, values.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!values.contains(val)) {
            return false;
        }
        int index = valueIndex.get(val);
        if (index != values.size() - 1) {
            Integer tempVal = values.get(values.size() - 1);
            values.set(index, tempVal);
            valueIndex.put(tempVal, index);
        }
        values.remove(values.size() - 1);
        valueIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(values.size());
        return values.get(randomIndex);
    }
}
