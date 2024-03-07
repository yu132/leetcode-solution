package redo.p2800_2899;

public class P2849 {

    class Solution {
        public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
            if (sx == fx && sy == fy && t == 1) {
                return false;
            }
            int xx = Math.abs(sx - fx), yy = Math.abs(sy - fy);
            return Math.max(xx, yy) <= t;
        }
    }

}
