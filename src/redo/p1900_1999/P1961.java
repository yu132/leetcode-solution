package redo.p1900_1999;

public class P1961 {

    class Solution {
        public boolean isPrefixString(String s, String[] words) {
            int indexWords = 0, innerWords = 0, indexS = 0;
            for (; indexS < s.length(); ++indexS) {
                if (innerWords == words[indexWords].length()) {
                    ++indexWords;
                    innerWords = 0;
                    if (indexWords == words.length) {
                        return false;
                    }
                }
                if (s.charAt(indexS) != words[indexWords].charAt(innerWords)) {
                    return false;
                }
                ++innerWords;
            }
            return innerWords == words[indexWords].length();
        }

    }

}
