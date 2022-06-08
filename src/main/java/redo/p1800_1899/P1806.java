package redo.p1800_1899;

public class P1806 {

    class Solution {
        public int reinitializePermutation(int n) {
            if (n == 2) {
                return 1;
            }
            int k = 1;
            for (int pow = 2; pow != 1; ++k) {
                pow = (pow * 2) % (n - 1);
            }
            return k;
        }
    }

}
