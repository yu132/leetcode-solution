package redo.p1900_1999;

public class P1946 {

    class Solution {
        public String maximumNumber(String num, int[] change) {

            char[] chs = num.toCharArray();

            for (int i = 0; i < num.length(); ++i) {
                int n = chs[i] - '0';
                if (change[n] > n) {
                    chs[i] = (char) (change[n] + '0');
                    for (int j = i + 1; j < num.length(); ++j) {
                        int x = chs[j] - '0';
                        if (change[x] < x) {
                            break;
                        }
                        chs[j] = (char) (change[x] + '0');
                    }
                    break;
                }
            }

            return new String(chs);
        }
    }

}
