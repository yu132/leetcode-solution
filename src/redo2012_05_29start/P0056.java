package redo2012_05_29start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P0056  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年6月6日  
 *  
 */
public class P0056 {

    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> ans = new ArrayList<>();

            Arrays.sort(intervals, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(b[1], a[1]);
            });

            int start = intervals[0][0], end = intervals[0][1];

            for (int i = 1; i < intervals.length; ++i) {
                int[] interval = intervals[i];
                if (interval[0] <= end) {
                    end = Math.max(end, interval[1]);
                } else {
                    ans.add(new int[] {start, end});
                    start = interval[0];
                    end = interval[1];
                }
            }

            ans.add(new int[] {start, end});

            return ans.toArray(new int[0][]);
        }
    }

}
