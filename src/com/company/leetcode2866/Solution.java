package com.company.leetcode2866;

import java.util.*;

/**
 * @author JesContes
 * @description 美丽塔，要求满足每一个实际高度都小于给定的最大高度，且存在一个坐标，从左边到这个坐标单调递增，向右单调递减，求高度和最大值。
 * 思路：从左向右求一遍递减值，再从右向左求一遍递减值，这个递减值在满足小于给定最大高度的前提下，要最大，然后再把两轮递减值的较小值求和
 * 以上思路叉掉，不能求递减值，因为中间元素实际大概率比头元素能取的值更大。
 * 参考官方题解：使用单调栈来求当前坐标最大和，同样是从左到右求一遍，从右到左求一遍，然后取所有坐标的最大和
 * 单调栈中存储的是坐标，当单调栈栈顶坐标的maxHeight小于当前i的maxHeight时，压栈，否则出栈，这样就相当于很方便地对前序元素的值做了修改
 * 计算公式为prefix[i]=prefix[j]+(i−j)×maxHeights[i]
 * @since 2023/12/21
 */
class Solution {
    /**
     * 求美丽塔最大高度和
     *
     * @param maxHeights 最大高度限制
     * @return 最大高度和
     */
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long[] leftDecHeight = new long[maxHeights.size()];
        Stack<Integer> leftStack = new Stack<>();
        for (int i = 0; i < leftDecHeight.length; i++) {
            while (!leftStack.isEmpty() && maxHeights.get(i) < maxHeights.get(leftStack.peek())) {
                leftStack.pop();
            }
            if (leftStack.isEmpty()) {
                leftDecHeight[i] = (long) maxHeights.get(i) * (i + 1);
            } else {
                leftDecHeight[i] = leftDecHeight[leftStack.peek()] + (long) maxHeights.get(i) * (i - leftStack.peek());
            }
            leftStack.push(i);
        }
        long[] rightDecHeight = new long[maxHeights.size()];
        Stack<Integer> rightStack = new Stack<>();
        long res = 0;
        for (int i = rightDecHeight.length - 1; i >= 0; i--) {
            while (!rightStack.isEmpty() && maxHeights.get(i) < maxHeights.get(rightStack.peek())) {
                rightStack.pop();
            }
            if (rightStack.isEmpty()) {
                rightDecHeight[i] = (long) maxHeights.get(i) * (rightDecHeight.length - i);
            } else {
                rightDecHeight[i] = rightDecHeight[rightStack.peek()] + (long) maxHeights.get(i) * (rightStack.peek() - i);
            }
            rightStack.push(i);
            res = Math.max(res, leftDecHeight[i] + rightDecHeight[i] - maxHeights.get(i));
        }
        return res;
    }
}
