package redo.p0700_0799;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class P710 {

    class Solution {

        private int n;
        private int[] blacklist;
        private Random r = new Random();

        public Solution(int n, int[] blacklist) {
            this.n = n;
            this.blacklist = blacklist;
            Arrays.sort(blacklist);
        }

        public int pick() {
            int rd = r.nextInt(n - blacklist.length);
            int idx = binarySearchMin(0, blacklist.length, mid -> rd + mid < blacklist[mid]);
            return idx + rd;
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
        Solution s = new P710().new Solution(7, new int[]{2, 3, 5});
        System.out.println(s.pick());
    }

}
