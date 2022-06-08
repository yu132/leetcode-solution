package redo.p2200_2299;

public class P2287 {

    class Solution {
        public int rearrangeCharacters(String s, String target) {
            int[] count = countLowercaseLetters(s);
            int min = Integer.MAX_VALUE;
            int[] count2 = countLowercaseLetters(target);
            for (int i = 0; i < 26; ++i) {
                if (count2[i] == 0) {
                    continue;
                }
                min = Math.min(count[i] / count2[i], min);
            }
            return min;
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
