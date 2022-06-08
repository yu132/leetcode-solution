package redo.p2200_2299;

public class P2264 {

    class Solution {
        public String largestGoodInteger(String num) {
            String ans = "";
            for (int i = 2; i < num.length(); ++i) {
                if (num.charAt(i) == num.charAt(i - 1)
                        && num.charAt(i) == num.charAt(i - 2)) {
                    ans = ans.compareTo(num.substring(i - 2, i + 1)) < 0 ? num.substring(i - 2, i + 1) : ans;
                }
            }
            return ans;
        }
    }

}
