package redo.p2400_2499;

public class P2413 {

    class Solution {
        public int smallestEvenMultiple(int n) {
            return mcm(n, 2);
        }

        public int gcd(int m, int n) {
            int r;
            while (n > 0) {
                r = m % n;
                m = n;
                n = r;
            }
            return m;
        }

        public int mcm(int m, int n) {
            return m * n / gcd(m, n);
        }
    }

}
