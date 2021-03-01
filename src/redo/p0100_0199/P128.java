package redo.p0100_0199;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**  
 * @ClassName: P128  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P128 {

    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();

            Map<Integer, Integer> ans = new HashMap<>();

            for (int num : nums) {
                set.add(num);
            }

            int max = 0;

            for (int num : nums) {
                max = Math.max(max, len(num, ans, set));
            }

            return max;
        }

        int len(int num, Map<Integer, Integer> ans, Set<Integer> set) {
            if (!set.contains(num)) {
                return 0;
            }
            if (!ans.containsKey(num)) {
                ans.put(num, len(num + 1, ans, set) + 1);
            }
            return ans.get(num);
        }
    }

}
