package redo.p2500_2599;

public class P2531 {

    class Solution {
        public boolean isItPossible(String word1, String word2) {
            int[] c1 = countLowercaseLetters(word1);
            int[] c2 = countLowercaseLetters(word2);

            int cc1 = 0, cc2 = 0;
            for (int i = 0; i < 26; ++i) {
                if (c1[i] > 0) {
                    ++cc1;
                }
                if (c2[i] > 0) {
                    ++cc2;
                }
            }

            if (Math.abs(cc1 - cc2) >= 3) {
                return false;
            }

            for (int i = 0; i < 26; ++i) {
                for (int j = 0; j < 26; ++j) {
                    if (c1[i] > 0 && c2[j] > 0) {
                        int temp1 = cc1, temp2 = cc2;
                        if (i != j) {
                            if (c1[i] == 1) {
                                --temp1;
                            }
                            if (c2[i] == 0) {
                                ++temp2;
                            }
                            if (c2[j] == 1) {
                                --temp2;
                            }
                            if (c1[j] == 0) {
                                ++temp1;
                            }
                        }
                        if (temp1 == temp2) {
                            return true;
                        }
                    }
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
