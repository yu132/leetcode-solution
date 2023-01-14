package redo.p2500_2599;

public class P2525 {

    class Solution {
        public String categorizeBox(int length, int width, int height, int mass) {
            boolean heavy = mass >= 100;
            boolean bulky = length >= 10_000 || width >= 10_000 || height >= 10_000
                    || (long) length * width * height >= 1_000_000_000;
            if (heavy && bulky) {
                return "Both";
            } else if (heavy) {
                return "Heavy";
            } else if (bulky) {
                return "Bulky";
            } else {
                return "Neither";
            }
        }
    }

}
