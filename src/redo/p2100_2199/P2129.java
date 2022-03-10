package redo.p2100_2199;

import java.util.ArrayList;
import java.util.List;

public class P2129 {

    class Solution {
        public String capitalizeTitle(String title) {
            List<int[]> ranges = splitAndRemoveEmptyReturnRange(title, ' ');
            char[] chs = title.toCharArray();
            for (int[] range : ranges) {
                int start = range[0], end = range[1];
                if (end - start <= 2) {
                    chs[start] = Character.toLowerCase(chs[start]);
                } else {
                    chs[start] = Character.toUpperCase(chs[start]);
                }
                for (int i = start + 1; i < end; ++i) {
                    chs[i] = Character.toLowerCase(chs[i]);
                }
            }
            return new String(chs);
        }

        public List<int[]> splitAndRemoveEmptyReturnRange(String str, char spliter) {
            int start = 0;
            List<int[]> ans = new ArrayList<>();
            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) == spliter) {
                    if (start == i) {
                        ++start;
                        continue;
                    }

                    ans.add(new int[]{start, i});

                    start = i + 1;
                }
            }

            if (start != str.length()) {
                ans.add(new int[]{start, str.length()});
            }

            return ans;
        }
    }

}
