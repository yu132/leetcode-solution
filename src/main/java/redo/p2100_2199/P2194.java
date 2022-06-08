package redo.p2100_2199;

import java.util.ArrayList;
import java.util.List;

public class P2194 {

    class Solution {
        public List<String> cellsInRange(String s) {
            char x1 = s.charAt(0), x2 = s.charAt(3);
            char y1 = s.charAt(1), y2 = s.charAt(4);

            List<String> ans = new ArrayList<>();

            for (char a = x1; a <= x2; ++a) {
                for (char b = y1; b <= y2; ++b) {
                    ans.add("" + a + b);
                }
            }

            return ans;
        }
    }

}
