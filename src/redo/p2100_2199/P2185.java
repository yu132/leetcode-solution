package redo.p2100_2199;

public class P2185 {

    class Solution {
        public int prefixCount(String[] words, String pref) {
            int count = 0;
            for (String word : words) {
                if (word.startsWith(pref)) {
                    ++count;
                }
            }
            return count;
        }
    }

}
