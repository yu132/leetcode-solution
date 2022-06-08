package redo.p1900_1999;

public class P1927 {

    class Solution {
        public boolean sumGame(String num) {

            int n = num.length();

            int[] sum = new int[2], countQ = new int[2];

            for (int i = 0; i < 2; ++i) {
                for (int j = i * (n / 2); j < (i + 1) * (n / 2); ++j) {
                    if (num.charAt(j) == '?') {
                        ++countQ[i];
                    } else {
                        sum[i] += num.charAt(j) - '0';
                    }
                }
            }
            if (sum[0] >= sum[1]) {

                int qDiff = countQ[1] - countQ[0];

                if (Math.abs(qDiff) % 2 == 1) {
                    return true;
                }

                return sum[0] - sum[1] != qDiff / 2 * 9;
            } else {

                int qDiff = countQ[0] - countQ[1];

                if (Math.abs(qDiff) % 2 == 1) {
                    return true;
                }

                return sum[1] - sum[0] != qDiff / 2 * 9;
            }
        }
    }

}
