package redo.p2600_2699;

public class P2678 {

    class Solution {
        public int countSeniors(String[] details) {
            int ans = 0;
            for (String item : details) {
                if (isMatch(item)) {
                    ++ans;
                }
            }
            return ans;
        }

        boolean isMatch(String detail) {
            return Integer.parseInt(detail.substring(11, 13)) >= 60;
        }
    }

}
