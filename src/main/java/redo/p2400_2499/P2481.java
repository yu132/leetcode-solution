package redo.p2400_2499;

public class P2481 {
    class Solution {
        public int numberOfCuts(int n) {
            return n == 1 || (n & 1) == 0 ? n / 2 : n;
        }
    }
}
