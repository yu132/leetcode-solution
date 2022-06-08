package redo.p2200_2299;

public class P2269 {

    class Solution {
        public int divisorSubstrings(int num, int k) {
            String str = Integer.toString(num);
            int count = 0;
            for (int i = 0; i <= str.length() - k; ++i) {
                int val = Integer.parseInt(str.substring(i, i + k));
                if (val != 0 && num % val == 0) {
                    ++count;
                }
            }
            return count;
        }
    }

}
