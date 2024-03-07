package redo.p2800_2899;

public class P2840 {

    class Solution {
        public boolean checkStrings(String s1, String s2) {
            int[] count1Odd = new int[26], count1Even = new int[26];
            int[] count2Odd = new int[26], count2Even = new int[26];
            for (int i = 0; i < s1.length(); ++i) {
                if ((i & 1) == 1) {
                    ++count1Odd[s1.charAt(i) - 'a'];
                    ++count2Odd[s2.charAt(i) - 'a'];
                } else {
                    ++count1Even[s1.charAt(i) - 'a'];
                    ++count2Even[s2.charAt(i) - 'a'];
                }
            }
            for (int i = 0; i < 26; ++i) {
                if (count1Odd[i] != count2Odd[i]) {
                    return false;
                }
                if (count1Even[i] != count2Even[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
