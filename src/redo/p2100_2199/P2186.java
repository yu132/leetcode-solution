package redo.p2100_2199;

public class P2186 {

    class Solution {
        public int minSteps(String s, String t) {
            int[] countS = countLowercaseLetters(s),
                    countT = countLowercaseLetters(t);

            int count = 0;

            for (int i = 0; i < 26; ++i) {
                if (countS[i] >= countT[i]) {
                    count += countS[i] - countT[i];
                } else {
                    count += countT[i] - countS[i];
                }
            }

            return count;
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
