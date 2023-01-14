package redo.p2400_2499;

public class P2457 {

    class Solution {
        public long makeIntegerBeautiful(long n, int target) {
            long tail = 1;
            long m, x;
            while (true) {
                m = x = n + (tail - n % tail) % tail;
                int s = 0;
                while (x != 0) {
                    s += x % 10;
                    x /= 10;
                }
                if (s <= target) {
                    return m - n;
                }
                tail *= 10;
            }
        }
    }

    public static void main(String[] args) {
        new P2457().new Solution().makeIntegerBeautiful(6068060761L, 3);

    }

}
