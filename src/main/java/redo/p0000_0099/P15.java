package redo.p0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: P15  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月21日  
 *  
 */
public class P15 {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Map<Integer, Integer> counter = new HashMap<>();

            for (int num : nums) {
                plus1(counter, num);
            }

            List<Integer> unique = new ArrayList<>(counter.keySet());

            Collections.sort(unique);

            List<List<Integer>> ans = new ArrayList<>();

            for (int i = 0; i < unique.size(); ++i) {
                int num1 = unique.get(i);
                for (int j = 0; j < i; ++j) {
                    int num2 = unique.get(j), num3 = -num1 - num2;
                    if (num3 < num1) {
                        continue;
                    }
                    if (counter.containsKey(num3)) {
                        if (num1 == num3 || num2 == num3) {
                            continue;
                        }
                        ans.add(Arrays.asList(num1, num2, num3));
                    }
                }
                if (counter.get(num1) >= 2) {
                    int num3 = -2 * num1;
                    if ((num1 == 0 && counter.get(num1) < 3)
                        || !counter.containsKey(num3)) {
                        continue;
                    }
                    ans.add(Arrays.asList(num1, num1, num3));
                }
            }

            return ans;
        }

        void plus1(Map<Integer, Integer> counter, int val) {
            counter.put(val, counter.getOrDefault(val, 0) + 1);
        }
    }

}
