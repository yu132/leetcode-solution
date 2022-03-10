package redo.p0400_0499;

import java.util.Arrays;

/**  
 * @ClassName: P452  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月18日  
 *  
 */
public class P452 {

    class Solution {
        public int findMinArrowShots(int[][] points) {

            if (points.length == 0) {
                return 0;
            }

            Arrays.sort(points, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(b[1], a[1]);
            });

            int end = points[0][1], count = 1;

            for (int i = 1; i < points.length; ++i) {
                if (end >= points[i][0]) {
                    end = Math.min(end, points[i][1]);
                } else {
                    ++count;
                    end = points[i][1];
                }
            }

            return count;
        }
    }

}
