package redo.p2000_2099;

public class P2048 {

    class Solution {
        public int nextBeautifulNumber(int n) {
            for (int i = n + 1; ; ++i) {
                if (isBeautiful(i)) {
                    return i;
                }
            }
        }

        boolean isBeautiful(int n) {
            if (n == 0) {
                return false;
            }
            int[] count = new int[7];
            while (n > 0) {
                int digit = n % 10;
                if (digit == 0 || digit >= 7) {
                    return false;
                }
                ++count[digit];
                if (count[digit] > digit) {
                    return false;
                }
                n /= 10;
            }
            for (int i = 1; i < 7; ++i) {
                if (count[i] != i && count[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
