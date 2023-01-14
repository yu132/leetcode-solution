package redo.p2400_2499;

public class P2443 {

    class Solution {
        public boolean sumOfNumberAndReverse(int num) {
            for (int i = 0; i <= num; ++i) {
                if (i + reverse(i) == num) {
                    return true;
                }
            }
            return false;
        }

        public int reverse(int num) {
            int rev = 0;
            while (num != 0) {
                rev = rev * 10 + num % 10;
                num /= 10;
            }
            return rev;
        }
    }


}
