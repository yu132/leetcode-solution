package redo.p0400_0499;

import java.util.Arrays;

/**  
 * @ClassName: P435  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月18日  
 *  
 */
public class P435 {

    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });

            int end = Integer.MIN_VALUE, count = 0;

            for (int[] interval : intervals) {

                if (end > interval[0]) {
                    ++count;
                    end = Math.min(end, interval[1]);
                } else {
                    end = interval[1];
                }

            }

            return count;
        }
    }

}
