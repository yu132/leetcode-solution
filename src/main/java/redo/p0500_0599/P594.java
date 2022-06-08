package redo.p0500_0599;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P594  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P594 {

    class Solution {
        public int findLHS(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                inc(map, num + 1);
                inc(map, num);
                set.add(num);
            }
            int max = 0;
            for (int num : map.keySet()) {
                if (set.contains(num) && set.contains(num - 1)) {
                    max = Math.max(max, map.get(num));
                }
            }
            return max;
        }

        private void inc(Map<Integer, Integer> map, int num) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.findLHS(new int[] {1, 3, 2, 2, 5, 2, 3, 7}));
        Assert.assertEquals(0, s.findLHS(new int[] {1, 1, 1}));
    }

}
