package redo.p2900_2999;

public class P2938 {

    class Solution {
        public long minimumSteps(String s) {
            long ans = 0;
            int count = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1') {
                    ++count;
                } else {
                    ans += count;
                }
            }
            return ans;
        }
    }

}
