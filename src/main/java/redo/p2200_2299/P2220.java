package redo.p2200_2299;

public class P2220 {

    class Solution {
        public int minBitFlips(int start, int goal) {
            return Integer.bitCount(start ^ goal);
        }
    }

}
