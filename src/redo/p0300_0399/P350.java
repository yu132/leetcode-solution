package redo.p0300_0399;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**  
 * @ClassName: P350  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P350 {

    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();

            for (int num : nums1) {
                map1.put(num, map1.getOrDefault(num, 0) + 1);
            }

            for (int num : nums2) {
                map2.put(num, map2.getOrDefault(num, 0) + 1);
            }

            List<Integer> ansList = new ArrayList<>();

            for (Iterator<Map.Entry<Integer, Integer>> it = map1.entrySet().iterator(); it.hasNext();) {
                Map.Entry<Integer, Integer> entry = it.next();
                if (!map2.containsKey(entry.getKey())) {
                    it.remove();
                } else {
                    for (int i = 0; i < Math.min(entry.getValue(), map2.get(entry.getKey())); ++i) {
                        ansList.add(entry.getKey());
                    }
                }
            }

            int[] ans = new int[ansList.size()];
            int index = 0;
            for (int num : ansList) {
                ans[index++] = num;
            }

            return ans;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {2, 2}, s.intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2}));
        assertArrayEquals(new int[] {4, 9}, s.intersect(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4}));
    }

}
