package redo.p0100_0199;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P149  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P149 {

    static//

    class Solution {
        public int maxPoints(int[][] points) {
            int n = points.length;

            int maxCount = 0;

            for (int i = 0; i < n; ++i) {

                Map<K, Integer> counter = new HashMap<>();

                for (int j = i + 1; j < n; ++j) {
                    K k = new K(points[i][0], points[i][1], points[j][0],
                        points[j][1]);
                    int count = counter.getOrDefault(k, 0) + 1;
                    counter.put(k, count);

                    maxCount = Math.max(maxCount, count);
                }
            }

            return maxCount + 1;
        }

        static class K {
            double k;

            int hash;

            K(int x1, int y1, int x2, int y2) {
                int xDiff = x2 - x1;
                int yDiff = y2 - y1;

                k = (double)yDiff / xDiff;

                if (k == -0.0) {
                    k = 0.0;
                }

                if (k == Double.NEGATIVE_INFINITY) {
                    k = Double.POSITIVE_INFINITY;
                }

                if (Math.abs(xDiff) >= Math.abs(yDiff)) {
                    if (yDiff != 0) {
                        hash = xDiff * 10 / yDiff;
                    } else {
                        hash = Integer.MAX_VALUE;
                    }
                } else {
                    int temp;
                    if (xDiff != 0) {
                        temp = yDiff * 10 / xDiff;
                    } else {
                        temp = Integer.MAX_VALUE;
                    }
                    hash = (temp << 16) | (temp >> 16);
                }
            }

            @Override
            public int hashCode() {
                return hash;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof K)) {
                    return false;
                }
                K o = (K)obj;
                return Double.compare(k, o.k) == 0;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(7, s.maxPoints(
            Arrs.build2D("[[0,1],[0,0],[0,4],[0,-2],[0,-1],[0,3],[0,-4]]")));
    }
}
