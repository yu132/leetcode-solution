package redo.p3200_3299;

public class P3258 {

    class Solution {
        public int countKConstraintSubstrings(String s, int k) {
            int[] count1 = new int[s.length() + 1];

            int c1 = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '1') {
                    ++c1;
                }
                count1[i + 1] = c1;
            }
            int ans = 0;
            for (int i = 0; i < s.length(); ++i) {
                for (int j = i; j < s.length(); ++j) {
                    int cc1 = count1[j + 1] - count1[i];
                    int len = j + 1 - i;
                    int cc0 = len - cc1;
                    if (cc1 <= k || cc0 <= k) {
                        ++ans;
                    }
                }
            }
            return ans;
        }
    }
}
