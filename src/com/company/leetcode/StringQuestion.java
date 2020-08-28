package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StringQuestion {
    //696. 计数二进制子串
    public int countBinarySubstrings(String s) {
        char BinaryCase;
        int num1, num0;
        int sum = 0;
        if (s.length() == 0){
            return 0;
        }
        num1 = 0;
        BinaryCase = s.charAt(0)=='0'? '1':'0';
        for (int i = 0; i < s.length();){
            num0 = num1;
            num1 = 0;
            BinaryCase = s.charAt(i);
            int j;
            for (j = i; j < s.length() && BinaryCase == s.charAt(j); j++){
                num1 ++;
            }
            sum += num0 < num1? num0: num1;
            i = j;
        }
        return sum;
    }

    //43. 字符串相乘
    public String multiply(String num1, String num2) {
        String MultiplyRes = "";
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        for (int i = 0; i < num2.length(); i++){
            MultiplyRes += "0";
            MultiplyRes = stringadd(multiplyOne(num1, num2.charAt(i)), MultiplyRes);
        }
        return MultiplyRes;
    }

    public String multiplyOne(String num1, char divisor){
        if (divisor == '0'){
            return "0";
        }
        int Tens = 0;
        String MultiRes = "";
        int DivisorInt = divisor - '0';
        for(int dividendIndex = num1.length() - 1; dividendIndex >= 0; dividendIndex--){
            int TempMultiRes = (num1.charAt(dividendIndex) - '0')*DivisorInt + Tens;
            MultiRes = TempMultiRes%10 + MultiRes;
            Tens = TempMultiRes/10;
        }
        if (Tens > 0){
            MultiRes = Tens + MultiRes;
        }
        return MultiRes;
    }

    public String stringadd(String num1, String num2){
        int Tens = 0;
        String AddRes = "";
        int TempRes;
        int AddIndex1, AddIndex2;
        for (AddIndex1 = num1.length() - 1, AddIndex2 = num2.length() - 1; AddIndex1 >= 0 && AddIndex2 >= 0; AddIndex1--, AddIndex2--){
            TempRes = (num1.charAt(AddIndex1) - '0') + (num2.charAt(AddIndex2) - '0') + Tens;
            AddRes = TempRes%10 + AddRes;
            Tens = TempRes/10;
        }
        for (;AddIndex1 >= 0; AddIndex1--){
            TempRes = (num1.charAt(AddIndex1) - '0') + Tens;
            AddRes = TempRes%10 + AddRes;
            Tens = TempRes/10;
        }
        for (;AddIndex2 >= 0; AddIndex2--){
            TempRes = (num2.charAt(AddIndex2) - '0') + Tens;
            AddRes = TempRes%10 + AddRes;
            Tens = TempRes/10;
        }
        if (Tens > 0){
            AddRes = Tens + AddRes;
        }
        return AddRes;
    }

    //20. 有效的括号
    public boolean isValid(String s) {
        Stack<Character> ParenthesesStack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('||s.charAt(i) == '['||s.charAt(i) == '{') {
                ParenthesesStack.push(s.charAt(i));
            }
            else {
                if (ParenthesesStack.empty()){
                    return false;
                }
                char ParenthesesTmp = ParenthesesStack.pop();
                if ((ParenthesesTmp == '('&&s.charAt(i)==')')||(ParenthesesTmp == '['&&s.charAt(i)==']')||(ParenthesesTmp == '{'&&s.charAt(i)=='}')){

                }
                else {
                    return false;
                }
            }

        }
        return ParenthesesStack.empty();
    }

    //647. 回文子串
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res += countLongestSingleMid(s, i);
            res += countLongestDoubleMid(s, i);
        }
        return res;
    }

    public int countLongestSingleMid(String s, int pos){
        int res = 1;
        while(pos - res >= 0 && pos + res < s.length() && s.charAt(pos - res) == s.charAt(pos + res)){
            res ++;
        }
        return res;
    }

    public int countLongestDoubleMid(String s, int pos){
        if (pos + 1 >= s.length() || s.charAt(pos) != s.charAt(pos + 1)){
            return 0;
        }
        int res = 1;
        while(pos - res >= 0 && pos + res + 1 < s.length() && s.charAt(pos - res) == s.charAt(pos + res + 1)){
            res ++;
        }
        return res;
    }

    //459. 重复的子字符串
    public boolean repeatedSubstringPattern(String s) {
        boolean isRepeated = false;
        if (s.length() == 0|| s.length() == 1){
            return false;
        }
        for (int i = 1; i <= s.length()/2; i++){
            isRepeated = true;
            if (s.length()%i==0){
                for (int j = i; j < s.length(); j++){
                    if (s.charAt(j) != s.charAt(j-i)){
                        isRepeated = false;
                        break;
                    }
                }
            }
            else {
                isRepeated = false;
            }
            if (isRepeated){
                break;
            }
        }
        return isRepeated;
    }

    //17. 电话号码的字母组合
    public List<String> letterCombinations(String digits) {
        List<String> MobileDigits = createDigitsList();
        List<String> res = new ArrayList<>();
        if (digits.length() > 0){
            getNextCharacter(0, MobileDigits, "", digits, res);
        }
        return res;
    }

    public List<String> createDigitsList(){
        List<String> s = new ArrayList<>();
        s.add("abc");
        s.add("def");
        s.add("ghi");
        s.add("jkl");
        s.add("mno");
        s.add("pqrs");
        s.add("tuv");
        s.add("wxyz");
        return s;
    }

    public void getNextCharacter(int pos, List<String> MobileDigits, String SingleCombination, String digits, List<String> res){
        if (pos == digits.length()){
            res.add(SingleCombination);
            return;
        }
        char ToAddNum = digits.charAt(pos);
        for (int i = 0; i < MobileDigits.get(ToAddNum - '2').length(); i++){
            getNextCharacter(pos + 1, MobileDigits, SingleCombination + MobileDigits.get(ToAddNum - '2').charAt(i), digits, res);
        }
    }

    //657. 机器人能否返回原点
    public boolean judgeCircle(String moves) {
        int YCount, XCount;
        YCount = XCount = 0;
        for (int i = 0; i < moves.length(); i++){
            if (moves.charAt(i) == 'U'){
                YCount++;
            } else if (moves.charAt(i) == 'D'){
                YCount--;
            } else if (moves.charAt(i) == 'L'){
                XCount++;
            } else if (moves.charAt(i) == 'R'){
                XCount--;
            }
        }
        return YCount == 0 && XCount == 0;
    }
}
