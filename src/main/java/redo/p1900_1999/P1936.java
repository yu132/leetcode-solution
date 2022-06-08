package redo.p1900_1999;

public class P1936 {

    class Solution {
        public int addRungs(int[] rungs, int dist) {
            int now = 0, ans = 0;
            for (int rung : rungs) {
                ans += (rung - now - 1) / dist;
                now = rung;
            }
            return ans;
        }
    }

}
