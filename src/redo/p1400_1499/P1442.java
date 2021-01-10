package redo.p1400_1499;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1442  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月8日  
 *  
 */
public class P1442 {

    static//

    class Solution {
        public int countTriplets(int[] arr) {
            ListMap<Integer, Integer> map = new ListMap<>();
            map.add(0, -1);
            int temp = 0, ans = 0;
            for (int i = 0; i < arr.length; ++i) {
                temp ^= arr[i];

                for (int j : map.get(temp)) {
                    ans += i - j - 1;
                }

                map.add(temp, i);
            }
            return ans;
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

        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.countTriplets(new int[] {2, 3, 1, 6, 7}));
        Assert.assertEquals(10, s.countTriplets(new int[] {1, 1, 1, 1, 1}));
        Assert.assertEquals(0, s.countTriplets(new int[] {2, 3}));
        Assert.assertEquals(3, s.countTriplets(new int[] {1, 3, 5, 7, 9}));
        Assert.assertEquals(8, s.countTriplets(new int[] {7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }

}
