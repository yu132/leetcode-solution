package redo.p2100_2199;

import java.util.Arrays;

public class P2126 {

    class Solution {
        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
            Arrays.sort(asteroids);
            long val = mass;
            for (int num : asteroids) {
                if (val >= num) {
                    val += num;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

}
