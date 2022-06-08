package redo.p2200_2299;

public class P2283 {

    class Solution {
        public boolean digitCount(String num) {
            int[] count = countNum(num);
            for (int i = 0; i < num.length(); ++i) {
                if (num.charAt(i) - '0' != count[i]) {
                    return false;
                }
            }
            return true;
        }

        int[] countNum(String str) {
            int[] count = new int[10];
            for (char ch : str.toCharArray()) {
                ++count[ch - '0'];
            }
            return count;
        }
    }

}
