package redo.p2500_2599;

public class P2582 {

    class Solution {
        public int passThePillow(int n, int time) {
            int temp = (time + 1) % (n + n - 2);
            if (temp <= n) {
                return temp;
            } else {
                return n + n - temp;
            }
        }
    }

}
