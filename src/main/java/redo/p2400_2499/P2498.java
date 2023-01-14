package redo.p2400_2499;

import redo.testUtil.Arrs;

import java.util.function.Function;

public class P2498 {

    class Solution {
        public int maxJump(int[] stones) {
            return binarySearchMin(1, stones[stones.length - 1] - stones[0],
                    mid -> helper(stones, mid));
        }

        boolean helper(int[] stones, int mid) {
            boolean[] used = new boolean[stones.length];
            int last = 0, lastAvailable = 0;
            for (int i = 1; i < stones.length; ++i) {
                if (!used[i]) {
                    if (stones[i] - stones[last] > mid) {
                        if (last == lastAvailable) {
                            return false;
                        }
                        last = lastAvailable;
                        used[lastAvailable] = true;
                        if (stones[i] - stones[lastAvailable] > mid) {
                            return false;
                        }
                    }
                    lastAvailable = i;
                }
            }
            if (lastAvailable != stones.length - 1) {
                return false;
            }
            last = 0;
            lastAvailable = 0;
            for (int i = 1; i < stones.length; ++i) {
                if (!used[i]) {
                    if (stones[i] - stones[last] > mid) {
                        if (last == lastAvailable) {
                            return false;
                        }
                        last = lastAvailable;
                        used[lastAvailable] = true;
                        if (stones[i] - stones[lastAvailable] > mid) {
                            return false;
                        }
                    }
                    lastAvailable = i;
                }
            }
            return lastAvailable == stones.length - 1;
        }

        public int binarySearchMin(int low, int high, Function<Integer, Boolean> judge) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (judge.apply(mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P2498().new Solution().helper(Arrs.build("[0,2,5,6,7]"), 5));
        System.out.println(new P2498().new Solution().maxJump(Arrs.build("[0,2,5,6,7]")));
    }

}
