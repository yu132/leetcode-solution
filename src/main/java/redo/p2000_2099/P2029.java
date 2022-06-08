package redo.p2000_2099;

public class P2029 {

    /**
     * 共三种情况， 求模为0，1，2
     * <p>
     * 0,1,2 0-n 1-0 2-0 Alice输
     * <p>
     * (1,x,y,z) = (1,x-1,y,z) = (2,x,y,z-1) = (0,x,y-1,z)
     * <p>
     * (0,x,y,z) = (0,x-1,y,z) = (1,x,y,z-1) = (2,x,y-1,z)
     */


    class Solution {
        public boolean stoneGameIX(int[] stones) {
            int[] count = new int[3];
            for (int num : stones) {
                ++count[num % 3];
            }
            if (count[0] % 2 == 0) {
                return count[1] >= 1 && count[2] >= 1;
            }
            return Math.abs(count[1] - count[2]) > 2;
        }
    }

}
