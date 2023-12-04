package com.company.odlesson;

/**
 * @author awmlk
 * 三个空汽水瓶可以换一瓶汽水，求用现有的空汽水瓶，能喝多少瓶汽水
 */
public class SodaBottle {
    /**
     * 用现有的空汽水瓶，能喝多少瓶汽水
     *
     * @param emptyBottle 空汽水瓶数
     * @return 能喝的汽水数
     */
    public int drinkSodaNum(int emptyBottle) {
        int result = 0;
        int remainBottle = emptyBottle;
        while (remainBottle / 3 > 0) {
            result += remainBottle / 3;
            remainBottle = remainBottle / 3 + remainBottle % 3;
        }
        // 如果最后剩2个瓶子，可以找老板借一个瓶子，再换一瓶，这样还可以还给老板一个瓶子
        if (remainBottle == 2) {
            result++;
        }
        return result;
    }
}
