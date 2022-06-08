package redo.p1800_1899;

public class P1899 {

    class Solution {
        public boolean mergeTriplets(int[][] triplets, int[] target) {

            boolean[] match = new boolean[3];
            int count = 0;

            outer:
            for (int[] tri : triplets) {
                for (int i = 0; i < 3; ++i) {
                    if (tri[i] > target[i]) {
                        continue outer;
                    }
                }
                for (int i = 0; i < 3; ++i) {
                    if (tri[i] == target[i]) {
                        if (!match[i]) {
                            match[i] = true;
                            ++count;
                            if (count == 3) {
                                return true;
                            }
                        }
                    }
                }
            }

            return false;
        }
    }

}
