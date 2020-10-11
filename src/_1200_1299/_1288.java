package _1200_1299;

import java.util.Arrays;

/**  
 * @ClassName: _1288  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月10日  
 *  
 */
public class _1288 {

    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(b[1], a[1]);
                }
            });

            int delete = 0;

            int max    = -1;
            for (int i = 0; i < intervals.length; ++i) {
                if (max >= intervals[i][1]) {
                    ++delete;
                } else {
                    max = intervals[i][1];
                }
            }

            return intervals.length - delete;
        }
    }

}
