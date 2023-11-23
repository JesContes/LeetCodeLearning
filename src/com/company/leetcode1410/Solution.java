package com.company.leetcode1410;

import java.util.Arrays;
import java.util.List;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * HTML符号集，注意&amp要在最后，不然可能会在转换&之后产生误转换
     */
    private static final List<String[]> HTML_SYMBOL = Arrays.asList(
            new String[]{"&quot;", "\""}, new String[]{"&apos;", "'"}, new String[]{"&gt;", ">"},
            new String[]{"&lt;", "<"}, new String[]{"&frasl;", "/"}, new String[]{"&amp;", "&"});
    /**
     * HTML 实体解析器
     *
     * @param text 原始字符串
     * @return 转换HTML符号后的字符串
     */
    public String entityParser(String text) {
        String result = text;
        for (String[] htmlSymbol : HTML_SYMBOL) {
            result = result.replace(htmlSymbol[0], htmlSymbol[1]);
        }
        return result;
    }
}
