package com.company.odlesson;

import org.junit.Test;

import static org.junit.Assert.*;

public class EnglishInputMethodTest {

    @Test
    public void wordsSeq() {
        EnglishInputMethod englishInputMethod = new EnglishInputMethod();
        String words1 = "I love you";
        String pre1 = "He";
        String result1 = englishInputMethod.wordsSeq(words1, pre1);
        assertEquals("He", result1);
        String words2 = "The furthest distance in the world,Is not between life and death,But when I stand in front or you,Yet you don't know that I love you.";
        String pre2 = "f";
        String result2 = englishInputMethod.wordsSeq(words2, pre2);
        assertEquals("front furthest", result2);
    }
}