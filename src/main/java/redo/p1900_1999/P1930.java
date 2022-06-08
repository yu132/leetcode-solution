package redo.p1900_1999;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P1930 {

    class Solution {
        public int countPalindromicSubsequence(String s) {
            int[] min = new int[26], max = new int[26];
            Arrays.fill(min, -1);
            Arrays.fill(max, -1);

            for (int i = 0; i < s.length(); ++i) {
                if (min[s.charAt(i) - 'a'] == -1) {
                    min[s.charAt(i) - 'a'] = i;
                }
            }

            for (int i = s.length() - 1; i >= 0; --i) {
                if (max[s.charAt(i) - 'a'] == -1) {
                    max[s.charAt(i) - 'a'] = i;
                }
            }

            int ans = 0;

            for (int i = 0; i < 26; ++i) {
                if (min[i] != -1 && min[i] != max[i]) {
                    Set<Character> set = new HashSet<>();
                    for (int j = min[i] + 1; j < max[i]; ++j) {
                        set.add(s.charAt(j));
                    }
                    ans += set.size();
                }
            }

            return ans;
        }
    }

}
