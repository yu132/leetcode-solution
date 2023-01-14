package old._0500_0599;

import java.util.Arrays;

/**  
 * @ClassName: _593  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月17日  
 *  
 */
public class _593 {

    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

            double[] dis = new double[6];

            dis[0] = distance(p1, p2);
            dis[1] = distance(p1, p3);
            dis[2] = distance(p1, p4);
            dis[3] = distance(p2, p3);
            dis[4] = distance(p2, p4);
            dis[5] = distance(p3, p4);

            Arrays.sort(dis);

            return equal(dis[0], dis[1]) && equal(dis[0], dis[2]) && equal(dis[0], dis[3]) && equal(dis[5], dis[6])
                && dis[3] < dis[4];
        }

        public boolean equal(double d1, double d2) {
            return Double.compare(d1, d2) == 0;
        }

        public double distance(int[] p1, int[] p2) {
            int d1 = p1[0] - p2[0], d2 = p1[1] - p2[1];
            return Math.sqrt(d1 * d1 + d2 * d2);
        }
    }

    public static void main(String[] args) {
        new _593().new Solution().validSquare(new int[] {0, 0}, new int[] {1, 1}, new int[] {1, 0}, new int[] {0, 1});
    }

}
