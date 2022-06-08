package redo.p0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P56  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P56 {

    class Solution {
        public int[][] merge(int[][] intervals) {

            if (intervals.length == 0) {
                return new int[0][];
            }

            List<int[]> ans = new ArrayList<>();

            Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(b[1], a[1]);
                }
                return Integer.compare(a[0], b[0]);
            });
            int start = intervals[0][0], end = intervals[0][1];
            for (int i = 1; i < intervals.length; ++i) {
                int s2 = intervals[i][0], e2 = intervals[i][1];
                if (s2 > end) {
                    ans.add(new int[] {start, end});
                    start = s2;
                    end = e2;
                } else {
                    end = Math.max(end, e2);
                }
            }
            ans.add(new int[] {start, end});

            return ans.toArray(new int[0][]);
        }
    }

}
