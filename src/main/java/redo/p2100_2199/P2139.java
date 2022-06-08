package redo.p2100_2199;

public class P2139 {

    class Solution {
        public int minMoves(int target, int maxDoubles) {

            int count = 0;

            while (target > 1) {
                if (maxDoubles == 0) {
                    return count + target - 1;
                }
                if (target % 2 == 0) {
                    ++count;
                } else {
                    count += 2;
                }
                target /= 2;
                --maxDoubles;
            }
            return count;
        }
    }

}
