package redo.p0300_0399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: P347  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P347 {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> counter = new HashMap<>();

            for (int num : nums) {
                plus1(counter, num);
            }

            List<Map.Entry<Integer, Integer>> list =
                new ArrayList<>(counter.entrySet());

            Collections.sort(list,
                (a, b) -> Integer.compare(b.getValue(), a.getValue()));

            int[] ans = new int[k];

            for (int i = 0; i < k; ++i) {
                ans[i] = list.get(i).getKey();
            }

            return ans;
        }

        void plus1(Map<Integer, Integer> counter, int val) {
            counter.put(val, counter.getOrDefault(val, 0) + 1);
        }
    }

}
