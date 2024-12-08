package redo.p2900_2999;

import redo.testUtil.Arrs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2901 {

    class Solution {
        public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
            int max = 0;
            int maxIndex = 0;
            int[] dp = new int[words.length];
            int[] pre = new int[words.length];
            for (int i = 0; i < words.length; ++i) {
                dp[i] = 1;
                pre[i] = -1;
                for (int j = i - 1; j >= 0; --j) {
                    if (words[i].length() == words[j].length() && groups[i] != groups[j]) {
                        if (checkHanMin(words[i], words[j])) {
                            if (dp[j] + 1 > dp[i]) {
                                pre[i] = j;
                                dp[i] = dp[j] + 1;
                                if (dp[i] > max) {
                                    max = dp[i];
                                    maxIndex = i;
                                }
                            }
                        }
                    }
                }
            }
            List<String> ans = new ArrayList<>();
            do {
                ans.add(words[maxIndex]);
                maxIndex = pre[maxIndex];
            } while (maxIndex != -1);
            Collections.reverse(ans);
            return ans;
        }

        boolean checkHanMin(String s1, String s2) {
            int count = 0;
            for (int i = 0; i < s1.length(); ++i) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    ++count;
                    if (count >= 2) {
                        return false;
                    }
                }
            }
            return count == 1;
        }
    }

    public static void main(String[] args) {
        new P2901().new Solution().getWordsInLongestSubsequence(new String[]{"cb", "dcc", "da", "cbb", "bd", "dbc", "ab", "db"}, Arrs.build("[4,5,5,7,8,1,3,4]"));
    }

}
