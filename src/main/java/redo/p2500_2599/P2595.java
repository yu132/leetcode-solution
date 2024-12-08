package redo.p2500_2599;

public class P2595 {

    class Solution {
        public int[] evenOddBit(int n) {
            int[] ans = new int[2];
            boolean isOdd = true;
            while (n != 0) {
                if ((n & 1) == 1) {
                    if (isOdd) {
                        ++ans[0];
                    } else {
                        ++ans[1];
                    }
                }
                isOdd = !isOdd;
                n >>= 1;
            }
            return ans;
        }
    }

}
