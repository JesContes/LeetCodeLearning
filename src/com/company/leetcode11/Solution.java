package com.company.leetcode11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 求装最多水的容器
     *
     * @param height 容器两边高度数列
     * @return 最大容量
     */
    public int maxArea(int[] height) {
        // 首先求从左数递增高度和从右数递增高度
        List<Integer> leftInc = new ArrayList<>();
        List<Integer> rightInc = new ArrayList<>();
        int tempMaxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > tempMaxHeight) {
                leftInc.add(i);
                tempMaxHeight = height[i];
            }
        }
        tempMaxHeight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > tempMaxHeight) {
                rightInc.add(i);
                tempMaxHeight = height[i];
            }
        }
        int maxArea = 0;
        for (Integer left : leftInc) {
            for (Integer right : rightInc) {
                if (left >= right) {
                    break;
                }
                int tempArea = (right - left)
                        * Math.min(height[right], height[left]);
                maxArea = Math.max(maxArea, tempArea);
            }
        }
        return maxArea;
    }
}
