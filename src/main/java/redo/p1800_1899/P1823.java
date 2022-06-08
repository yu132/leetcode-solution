package redo.p1800_1899;

public class P1823 {

    class Solution {
        public int findTheWinner(int n, int k) {
            return josephus(n, k) + 1;
        }

        int josephus(int num, int m) {
            int f = 0;
            for (int i = 2; i <= num; ++i) {
                f = (m + f) % i;
            }
            return f;
        }
    }


}
