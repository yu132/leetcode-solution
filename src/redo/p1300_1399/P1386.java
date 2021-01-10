package redo.p1300_1399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1386  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1386 {

    static//

    class Solution {
        public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

            ListMap<Integer, int[]> maps = new ListMap<>();

            for (int[] reservedSeat : reservedSeats) {
                maps.add(reservedSeat[0], reservedSeat);
            }

            int count = n * 2;

            for (int key : maps.keys()) {

                boolean[] seats = new boolean[10];

                for (int[] reservedSeat : maps.get(key)) {
                    seats[reservedSeat[1] - 1] = true;
                }

                boolean f1 = true, f2 = true;
                for (int j = 1; j <= 4; ++j) {
                    if (seats[j]) {
                        f1 = false;
                        break;
                    }
                }
                for (int j = 5; j <= 8; ++j) {
                    if (seats[j]) {
                        f2 = false;
                        break;
                    }
                }
                if (!f1) {
                    --count;
                }
                if (!f2) {
                    --count;
                }
                if (!f1 && !f2) {
                    boolean f3 = true;
                    for (int j = 3; j <= 6; ++j) {
                        if (seats[j]) {
                            f3 = false;
                            break;
                        }
                    }
                    if (f3) {
                        ++count;
                    }
                }
            }
            return count;
        }

        static class ListMap<K, E> {

            Map<K, List<E>> map = new HashMap<>();

            public void add(K key, E element) {
                map.computeIfAbsent(key, (x) -> new ArrayList<>()).add(element);
            }

            public void remove(K key, E element) {
                map.computeIfAbsent(key, (x) -> new ArrayList<>()).remove(element);
            }

            public List<E> get(K key) {
                return map.getOrDefault(key, Collections.emptyList());
            }

            public Set<K> keys() {
                return map.keySet();
            }

        }
    }


    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.maxNumberOfFamilies(3, Arrs.build2D("[[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]")));
        Assert.assertEquals(2, s.maxNumberOfFamilies(2, Arrs.build2D("[[2,1],[1,8],[2,6]]")));
        Assert.assertEquals(4, s.maxNumberOfFamilies(4, Arrs.build2D("[[4,3],[1,4],[4,6],[1,7]]")));
    }
}
