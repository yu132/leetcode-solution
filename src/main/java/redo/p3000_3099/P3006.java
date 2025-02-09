package redo.p3000_3099;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class P3006 {

    class Solution {
        public List<Integer> beautifulIndices(String s, String a, String b, int k) {
            List<Integer> aa = new ArrayList<>();
            TreeSet<Integer> bb = new TreeSet<>();

            for (int i = 0; i <= s.length() - a.length(); ++i) {
                if (s.startsWith(a, i)) {
                    aa.add(i);
                }
            }
            for (int i = 0; i <= s.length() - b.length(); ++i) {
                if (s.startsWith(b, i)) {
                    bb.add(i);
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int aaa : aa) {
                Integer floor = bb.floor(aaa);
                if (null != floor && aaa - floor <= k) {
                    ans.add(aaa);
                    continue;
                }
                Integer ceil = bb.ceiling(aaa);
                if (null != ceil && ceil - aaa <= k) {
                    ans.add(aaa);
                }
            }

            return ans;
        }
    }

}
