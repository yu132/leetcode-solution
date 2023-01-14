package old._0200_0299;

import java.util.Arrays;
import java.util.PriorityQueue;

/**  
 * @ClassName: _253  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月7日  
 *  
 */
public class _253 {

    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });

            PriorityQueue<int[]> now = new PriorityQueue<int[]>((a, b) -> {
                                         return Integer.compare(a[1], b[1]);
                                     });

            int                  max = 0;
            for (int[] each : intervals) {
                int start = each[0];
                while (!now.isEmpty() && now.peek()[1] <= start) {
                    now.poll();
                }
                now.offer(each);
                max = Math.max(max, now.size());
            }
            return max;
        }
    }

}
