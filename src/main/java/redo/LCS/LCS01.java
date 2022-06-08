package redo.LCS;

public class LCS01 {

    class Solution {
        public int leastMinutes(int n) {
            if (n == 1) {
                return 1;
            }
            return bitLen((Integer.highestOneBit(n - 1) << 1));
        }

        public int bitLen(int num) {
            int temp, len = 0;
            if ((temp = num >>> 16) != 0) {
                num = temp;
                len += 16;
            }
            if ((temp = num >>> 8) != 0) {
                num = temp;
                len += 8;
            }
            if ((temp = num >>> 4) != 0) {
                num = temp;
                len += 4;
            }
            if ((temp = num >>> 2) != 0) {
                num = temp;
                len += 2;
            }
            if ((temp = num >>> 1) != 0) {
                num = temp;
                len += 1;
            }
            if (num == 1) {
                len += 1;
            }
            return len;
        }
    }

}
