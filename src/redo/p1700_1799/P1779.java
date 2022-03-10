package redo.p1700_1799;

/**  
 * @ClassName: P1779  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月28日  
 *  
 */
public class P1779 {

    class Solution {
        public int nearestValidPoint(int x, int y, int[][] points) {
            int minDis = Integer.MAX_VALUE, minIndex = -1;
            for (int i = 0; i < points.length; ++i) {
                int[] point = points[i];
                if (x == point[0] || y == point[1]) {
                    int dis = Math.abs(x - point[0] + y - point[1]);
                    if (dis < minDis) {
                        minDis = dis;
                        minIndex = i;
                    }
                }
            }
            return minIndex;
        }
    }

}
