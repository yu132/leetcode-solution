package redo.p2900_2999;

import java.util.ArrayList;
import java.util.List;

public class P2900 {

    class Solution {
        public List<String> getLongestSubsequence(String[] words, int[] groups) {
            List<String> ans = new ArrayList<>();
            ans.add(words[0]);
            for (int i = 1; i < words.length; ++i) {
                if (groups[i] != groups[i - 1]) {
                    ans.add(words[i]);
                }
            }
            return ans;
        }
    }

}
