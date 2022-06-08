package redo.p0900_0999;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P963  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P963 {

    static//

    class Solution {
        public double minAreaFreeRect(int[][] points) {
            Map<Integer, ListMap<Long, int[]>> map = new HashMap<>();
            for (int i = 0; i < points.length; ++i) {
                for (int j = i + 1; j < points.length; ++j) {
                    int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];

                    int disPow2 = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);

                    int midxMul2 = x1 + x2, midyMul2 = y1 + y2;

                    map.computeIfAbsent(disPow2, (x) -> new ListMap<>()).add(hash(midxMul2, midyMul2),
                        new int[] {x1, y1});
                }
            }

            double[] area = new double[] {Double.MAX_VALUE};
            map.forEach((disPow2, listMap) -> {
                listMap.map.forEach((midHash, list) -> {
                    for (int i = 0; i < list.size(); ++i) {
                        for (int j = i + 1; j < list.size(); ++j) {
                            int x1 = list.get(i)[0], y1 = list.get(i)[1], x2 = list.get(j)[0], y2 = list.get(j)[1];
                            int lenPow2 = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
                            int widthPow2 = disPow2 - lenPow2;
                            double len = Math.sqrt(lenPow2), width = Math.sqrt(widthPow2);
                            area[0] = Math.min(area[0], len * width);
                        }
                    }
                });
            });
            if (Double.compare(area[0], Double.MAX_VALUE) == 0) {
                return 0;
            }
            return area[0];
        }

        long hash(int x, int y) {
            return x + 80001 * y;
        }

        static class ListMap<K, E> {

            Map<K, List<E>> map = new HashMap<>();

            public void add(K key, E element) {
                get(key).add(element);
            }

            public void remove(K key, E element) {
                get(key).remove(element);
            }

            public List<E> get(K key) {
                return map.computeIfAbsent(key, (x) -> new ArrayList<>());
            }

        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2.0, s.minAreaFreeRect(Arrs.build2D("[[1,2],[2,1],[1,0],[0,1]]")), 0.00001);
        Assert.assertEquals(1.0, s.minAreaFreeRect(Arrs.build2D("[[0,1],[2,1],[1,1],[1,0],[2,0]]")), 0.00001);
        Assert.assertEquals(0.0, s.minAreaFreeRect(Arrs.build2D("[[0,3],[1,2],[3,1],[1,3],[2,1]]")), 0.00001);
        Assert.assertEquals(2.0, s.minAreaFreeRect(Arrs.build2D("[[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]")),
            0.00001);

    }

}
