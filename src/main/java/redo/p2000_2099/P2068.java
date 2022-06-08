package redo.p2000_2099;

public class P2068 {

    class Solution {
        public boolean checkAlmostEquivalent(String word1, String word2) {
            int[] counter1 = countLowercaseLetters(word1),
                    counter2 = countLowercaseLetters(word2);

            for (int i = 0; i < 26; ++i) {
                if (Math.abs(counter1[i] - counter2[i]) > 3) {
                    return false;
                }
            }
            return true;
        }

        public int[] countLowercaseLetters(String str) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                ++count[ch - 'a'];
            }
            return count;
        }
    }

}
