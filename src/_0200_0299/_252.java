package _0200_0299;

import java.util.Arrays;

/**  
 * @ClassName: _252  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月26日  
 *  
 */
public class _252 {

    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                return Integer.compare(a[0], b[0]);
            });
            for (int i = 1; i < intervals.length; ++i) {
                if (intervals[i - 1][1] > intervals[i][0]) {
                    return false;
                }
            }
            return true;
        }
    }

}
