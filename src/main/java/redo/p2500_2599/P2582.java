package redo.p2500_2599;

public class P2582 {

    class Solution {
        public int passThePillow(int n, int time) {
            int temp = time % (n + n - 2) + 1;
            if (temp <= n) {
                return temp;
            } else {
                return n + n - temp;
            }
        }
    }

}
