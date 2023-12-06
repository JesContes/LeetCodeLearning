package com.company.odlesson;

/**
 * @author awmlk
 *
 * 给出一个自然数，求连续自然数之和等于目标数的组合，也包含数字自身，例如9.输出所有的组合及组合数，如下
 * 9=9
 * 9=4+5
 * 9=2+3+4
 * Result:3
 * 先给出自身，然后累加公式规律是(2x+i-1)*i/2=t，如果无法求出整数，则认为不成立
 * 循环截止条件是当x等于1时，(i+1)*i>2t
 */
public class ContinuousNaturalNum {
    /**
     * 求连续自然数之和等于目标数的组合，结果输出到控制台
     *
     * @param target 目标和
     */
    public void solve(int target) {
        System.out.println(target + "=" + target);
        int result = 1;
        int i = 2;
        while ((i + 1)*i <= 2 * target) {
            if (target * 2 % i != 0) {
                i++;
                continue;
            }
            if ((target * 2 / i + 1 - i) % 2 != 0) {
                i++;
                continue;
            }
            int x = (target * 2 / i + 1 - i) / 2;
            StringBuilder builder = new StringBuilder();
            builder.append(target);
            builder.append("=");
            for (int j = 0; j < i; j++) {
                builder.append(x+j);
                if (j < i - 1) {
                    builder.append("+");
                }
            }
            System.out.println(builder.toString());
            result++;
            i++;
        }
        System.out.println("Result:"+result);
    }
}
