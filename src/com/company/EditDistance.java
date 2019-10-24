package com.company;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0) {
            return -1;
        }
        int edits[][] = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 0; i < word1.length() + 1; i++) {
            for(int j = 0; j < word2.length() + 1; j++) {
                edits[i][j] = j;
            }
            edits[i][0] = i;
        }

        for(int i = 1; i < word1.length() + 1; i++) {
            for(int j = 1; i < word2.length() + 1; j++)
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    edits[i][j] = 1 + Math.min(edits[i - 1][j - 1], Math.min(edits[i - 1][j], edits[i][j - 1]));
                }
        }
        return edits[word1.length()][word2.length()];

    }
    public static void main(String[] args) {
        String a = "horse";
        String b = "ros";
        int res = minDistance(a, b);
        System.out.print(res);

    }
}
