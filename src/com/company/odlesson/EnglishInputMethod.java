package com.company.odlesson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author awmlk
 * 主管期望你来实现英文输入法单词联想功能，需求如下：
 * 依据用户输入的单词前缀，从已输入的英文语句中联想出用户想输入的单词。
 * 按字典序输出联想到的单词序列，如果联想不到，请输出用户输入的单词前缀。
 * 注意
 * 英文单词联想时区分大小写
 * 缩略形式如"don't" 判定为两个单词 "don"和 "t"
 * 输出的单词序列不能有重复单词，且只能是英文单词，不能有标点符号
 */
public class EnglishInputMethod {
    /**
     * 英文单词联想
     *
     * @param words 单词字典语句，可能包含各种标点符号
     * @param pre 用户输入前缀
     * @return 按字典序输出联想到的单词序列
     */
    public String wordsSeq(String words, String pre) {
        int i = 0;
        List<String> chaList = new ArrayList<>();
        while (i < words.length()) {
            while (i < words.length() && !checkCharacter(words.charAt(i))) {
                i++;
            }
            if (i >= words.length()) {
                break;
            }
            int k = i + 1;
            while (k < words.length() && checkCharacter(words.charAt(k))) {
                k++;
            }
            if (!chaList.contains(words.substring(i, k))) {
                chaList.add(words.substring(i, k));
            }
            i = k + 1;
        }
        Collections.sort(chaList);
        List<String> preList = new ArrayList<>();
        for (String cha : chaList) {
            if (cha.startsWith(pre)) {
                preList.add(cha);
            }
        }
        if (preList.isEmpty()) {
            preList.add(pre);
        }
        return String.join(" ", preList);
    }

    /**
     * 判定c是否是英文字符
     *
     * @param c 字符
     * @return 是否是英文字符
     */
    private boolean checkCharacter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
