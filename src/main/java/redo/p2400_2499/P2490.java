package redo.p2400_2499;

public class P2490 {

    class Solution {
        public boolean isCircularSentence(String sentence) {
            String[] words = sentence.split(" ");
            for (int i = 1; i < words.length; ++i) {
                if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                    return false;
                }
            }
            return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);
        }
    }

}
