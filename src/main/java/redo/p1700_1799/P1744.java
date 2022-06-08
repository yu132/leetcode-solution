package redo.p1700_1799;

import redo.testUtil.Arrs;

public class P1744 {

    static//

    class Solution {
        public boolean[] canEat(int[] candiesCount, int[][] queries) {

            long[] prefix = prefix(candiesCount);

            boolean[] ans = new boolean[queries.length];
            int index = 0;

            for (int[] query : queries) {
                int ft = query[0], fd = query[1], dc = query[2];
                Range r1 = new Range(sumRange(prefix, 0, ft) + 1, sumRange(prefix, 0, ft + 1));
                Range r2 = new Range(fd + 1, (long) dc * (fd + 1));
                ans[index++] = r1.overlapStrong(r2);
            }

            return ans;
        }

        // 前缀和 sum(0 to i)=prefix[i+1];
        long[] prefix(int[] nums) {
            long[] prefix = new long[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            return prefix;
        }

        long sumRange(long[] prefix, int from, int to) {
            return prefix[to] - prefix[from];
        }

        class Range {
            long start;
            long end;

            Range(long start, long end) {
                super();
                this.start = start;
                this.end = end;
            }

            public boolean isValueInRange(int value) {
                return start <= value && value <= end;
            }

            public boolean overlapStrong(Range other) {
                return !(other.end < start || end < other.start);
            }
        }

    }

    public static void main(String[] args) {
        new Solution().canEat(new int[]{46, 5, 47, 48, 43, 34, 15, 26, 11, 25, 41, 47, 15, 25, 16, 50, 32, 42, 32, 21, 36, 34, 50, 45, 46, 15, 46, 38, 50, 12, 3, 26, 26, 16, 23, 1, 4, 48, 47, 32, 47, 16, 33, 23, 38, 2, 19, 50, 6, 19, 29, 3, 27, 12, 6, 22, 33, 28, 7, 10, 12, 8, 13, 24, 21, 38, 43, 26, 35, 18, 34, 3, 14, 48, 50, 34, 38, 4, 50, 26, 5, 35, 11, 2, 35, 9, 11, 31, 36, 20, 21, 37, 18, 34, 34, 10, 21, 8, 5},
                Arrs.build2D("[[11,387,25]]"));
    }

}
