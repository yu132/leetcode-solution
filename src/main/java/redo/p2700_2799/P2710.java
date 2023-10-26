package redo.p2700_2799;

public class P2710 {

    class Solution {
        public String removeTrailingZeros(String num) {
            for (int i = num.length() - 1; i >= 0; --i) {
                if (num.charAt(i) != '0') {
                    return num.substring(0, i + 1);
                }
            }
            return "";
        }
    }

}
