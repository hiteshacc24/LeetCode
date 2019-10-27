package com.company;
import java.util.*;
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        return word_break(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    public static boolean word_break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if(start == s.length()) {
            return true;
        }
        if(memo[start] != null) {
            return memo[start];
        }
        for(int end = start + 1; end <= s.length(); end++) {
            if(wordDict.contains(s.substring(start, end)) && word_break(s, wordDict, end, memo)) {
                memo[start] = true;
                return memo[start];
            }
        }
        memo[start] = false;
        return memo[start];
    }
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.print(wordBreak("leetcode", wordDict));
    }
}
