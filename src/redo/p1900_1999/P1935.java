package redo.p1900_1999;

public class P1935 {

    class Solution {
        public int canBeTypedWords(String text, String brokenLetters) {
            boolean[] notUsable = new boolean[26];

            for (char ch : brokenLetters.toCharArray()) {
                notUsable[ch - 'a'] = true;
            }

            int wordIsPrintable = 0;

            l:
            for (String word : text.split(" ")) {
                for (char ch : word.toCharArray()) {
                    if (notUsable[ch - 'a']) {
                        continue l;
                    }
                }
                ++wordIsPrintable;
            }

            return wordIsPrintable;
        }
    }

}
