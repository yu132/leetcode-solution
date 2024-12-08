package redo.p2900_2999;

public class P2937 {

    class Solution {
        public int findMinimumOperations(String s1, String s2, String s3) {
            int eqCount = 0;
            for (int i = 0; i < s1.length() && i < s2.length() && i < s3.length(); ++i) {
                if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
                    ++eqCount;
                } else {
                    break;
                }
            }
            if (eqCount == 0) {
                return -1;
            }
            return s1.length() + s2.length() + s3.length() - eqCount * 3;
        }
    }

}
