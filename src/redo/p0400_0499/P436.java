package redo.p0400_0499;

import java.util.Arrays;

/**  
 * @ClassName: P436  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月18日  
 *  
 */
public class P436 {

    class Solution {
        public int[] findRightInterval(int[][] intervals) {

            int n = intervals.length;

            Integer[] indexes = new Integer[n];

            Arrays.setAll(indexes, (x) -> x);

            Arrays.sort(indexes,
                (a, b) -> Integer.compare(intervals[a][0], intervals[b][0]));

            int[] ans = new int[n];

            for (int i = 0; i < n; ++i) {
                ans[i] = lowerBound(intervals[i][1], intervals, indexes, n);
            }

            return ans;
        }

        int lowerBound(int end, int[][] intervals, Integer[] indexes, int n) {
            int low = 0, high = n;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (end <= intervals[indexes[mid]][0]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            if (low == n) {
                return -1;
            }
            return indexes[low];
        }
    }

}
