package redo.p3000_3099;

import java.util.Arrays;

public class P3014 {

    class Solution {
        public int minimumPushes(String word) {
            int[] count = new int[26];
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }
            Arrays.sort(count);
            int c = 0;
            for (int i = 25; i >= 0; --i) {
                if (count[i] == 0) {
                    break;
                }
                c += ((25 - i) / 8 + 1) * count[i];
            }
            return c;
        }
    }
}
