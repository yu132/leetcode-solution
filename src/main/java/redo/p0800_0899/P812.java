package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P812  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P812 {

    class Solution {
        public double largestTriangleArea(int[][] points) {
            double maxArea = 0;
            for (int i = 0; i < points.length; ++i) {
                for (int j = i + 1; j < points.length; ++j) {
                    for (int k = j + 1; k < points.length; ++k) {
                        maxArea = Math.max(maxArea,
                            area(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
                    }
                }
            }
            return maxArea;
        }

        public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
            return (double)Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.largestTriangleArea(new int[][] {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}), 0.00001);
    }

}
