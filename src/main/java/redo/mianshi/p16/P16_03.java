package redo.mianshi.p16;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P16_03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月13日  
 *  
 */
public class P16_03 {

    class Solution {
        public double[] intersection(int[] start1, int[] end1, int[] start2,
            int[] end2) {
            int x1 = start1[0], y1 = start1[1], x2 = end1[0], y2 = end1[1],
                x3 = start2[0], y3 = start2[1], x4 = end2[0], y4 = end2[1];

            double[] ans = new double[0];

            if (k(x1, y1, x2, y2) == k(x3, y3, x4, y4)) {// 平行

                if (sameLine(x1, y1, x2, y2, x3, y3)) {// 共线，最小的必为4个端点
                    ans = checkAndCompare(x1, y1, x2, y2, x3, y3, ans);
                    ans = checkAndCompare(x1, y1, x2, y2, x4, y4, ans);
                    ans = checkAndCompare(x3, y3, x4, y4, x1, y1, ans);
                    ans = checkAndCompare(x3, y3, x4, y4, x2, y2, ans);
                }

                return ans;
            }

            // 不平行的线段交点公式
            double a1 = (double)((x1 * y2 - y1 * x2) * (x3 - x4)
                - (x1 - x2) * (x3 * y4 - y3 * x4))
                / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));

            double a2 = (double)((x1 * y2 - y1 * x2) * (y3 - y4)
                - (y1 - y2) * (x3 * y4 - y3 * x4))
                / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));

            // 判断交点是否在两条线段上
            if (contain(x1, y1, x2, y2, a1, a2)
                && contain(x3, y3, x4, y4, a1, a2)) {
                return new double[] {a1, a2};
            }

            return ans;
        }

        double k(double x1, double y1, double x2, double y2) {
            return (x2 - x1) / (y2 - y1);
        }

        boolean sameLine(int x1, int y1, int x2, int y2, int x3, int y3) {
            if ((x1 == x3 && y1 == y3) || (x2 == x3 && y2 == y3)) {
                return true;
            }
            return k(x1, y1, x3, y3) == k(x2, y2, x3, y3);
        }

        double[] checkAndCompare(int x1, int y1, int x2, int y2, double x,
            double y, double[] ans) {

            if (!contain(x1, y1, x2, y2, x, y)) {
                return ans;
            }

            if (ans.length != 0 && little(ans[0], ans[1], x, y)) {
                return ans;
            }

            return new double[] {x, y};
        }

        // 平行且共线的情况下检查是点是否在线段内
        boolean contain(int x1, int y1, int x2, int y2, double x, double y) {
            int xMin = Math.min(x1, x2), xMax = xMin == x1 ? x2 : x1;
            int yMin = Math.min(y1, y2), yMax = yMin == y1 ? y2 : y1;
            return xMin <= x && x <= xMax && yMin <= y && y <= yMax;
        }

        boolean little(double x1, double y1, double x2, double y2) {
            if (x1 < x2) {
                return true;
            } else if (x1 > x2) {
                return false;
            } else if (y1 <= y2) {
                return true;
            } else {
                return false;
            }
        }
    }


    @Test
    public void test() {
        Solution s = new Solution();

        int[] start1 = new int[] {0, 0}, end1 = new int[] {0, 1},
            start2 = new int[] {0, 0}, end2 = new int[] {0, -1};


        Assert.assertArrayEquals(new double[] {0, 0},
            s.intersection(start1, end1, start2, end2), 0.00001);
    }
}
