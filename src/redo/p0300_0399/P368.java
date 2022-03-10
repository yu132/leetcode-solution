package redo.p0300_0399;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**  
 * @ClassName: P368  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P368 {

    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {

            if (nums.length == 0) {
                return Collections.emptyList();
            }

            int n = nums.length;

            Arrays.sort(nums);

            int[] count = new int[n], parent = new int[n];

            Arrays.fill(parent, -1);

            int max = 0, maxNode = -1;

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (nums[i] % nums[j] == 0) {

                        if (count[j] + 1 > count[i]) {
                            count[i] = count[j] + 1;
                            parent[i] = j;

                            if (count[i] > max) {
                                max = count[i];
                                maxNode = i;
                            }
                        }
                    }
                }
            }

            LinkedList<Integer> ans = new LinkedList<>();

            for (int node = maxNode; node != -1; node = parent[node]) {
                ans.addFirst(nums[node]);
            }

            if (ans.size() == 0) {
                ans.add(nums[0]);
            }

            return ans;
        }
    }

}
