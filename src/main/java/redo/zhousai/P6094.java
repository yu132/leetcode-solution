package redo.zhousai;

import java.util.HashSet;

public class P6094 {

    class Solution {
        public long distinctNames(String[] ideas) {
            int[] count = new int[26];
            HashSet<String> set = new HashSet<>();
            for (String str : ideas) {
                ++count[str.charAt(0) - 'a'];
                set.add(str);
            }
            int[][] count2 = new int[26][26];
            long ans = 0;
            for (String str : ideas) {
                for (int i = 0; i < 26; ++i) {
                    if (set.contains((char) ('a' + i) + str.substring(1))) {
                        continue;
                    }
                    ans += count[i];
                    ++count2[i][str.charAt(0) - 'a'];
                }
            }
            for (String str : ideas) {
                for (int i = 0; i < 26; ++i) {
                    if (set.contains((char) ('a' + i) + str.substring(1))) {
                        ans -= count2[str.charAt(0) - 'a'][i];
                    }
                }
            }
            return ans;
        }

    }

}
