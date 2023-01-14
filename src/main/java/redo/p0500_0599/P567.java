package redo.p0500_0599;

import java.util.Arrays;

public class P567 {

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }
            int[] count1 = countLowercaseLetters(s1), count2 = new int[26];
            for (int i = 0; i < s1.length(); ++i) {
                ++count2[s2.charAt(i) - 'a'];
            }
            if (Arrays.equals(count1, count2)) {
                return true;
            }
            for (int i = s1.length(); i < s2.length(); ++i) {
                --count2[s2.charAt(i - s1.length()) - 'a'];
                ++count2[s2.charAt(i) - 'a'];
                if (Arrays.equals(count1, count2)) {
                    return true;
                }
            }
            return false;
        }

        //str中必须仅包含小写字符，计算每个小写字符的数量
        public int[] countLowercaseLetters(String str) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                ++count[ch - 'a'];
            }
            return count;
        }
    }

}
