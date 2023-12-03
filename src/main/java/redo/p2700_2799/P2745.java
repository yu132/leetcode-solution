package redo.p2700_2799;

public class P2745 {

    class Solution {
        public int longestString(int x, int y, int z) {
            int min = Math.min(x, y);
            return (min * 2 + (x > min || y > min ? 1 : 0) + z) * 2;
        }
    }


}
