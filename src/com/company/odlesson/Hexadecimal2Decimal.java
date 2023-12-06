package com.company.odlesson;

/**
 * @author awmlk
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示
 */
public class Hexadecimal2Decimal {
    /**
     * 十六进制转十进制
     *
     * @param hex 十六进制
     * @return 十进制表示
     */
    public Integer convert(String hex) {
        int prefixCount = 0;
        int result = 0;
        for (char c : hex.toCharArray()) {
            if (prefixCount < 2) {
                prefixCount++;
                continue;
            }
            result = result * 16 + ((c >= '0' && c <= '9') ? c - '0' : c - 'A' + 10);
        }
        return result;
    }
}
