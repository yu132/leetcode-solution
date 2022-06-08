package redo.p0300_0399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**  
 * @ClassName: P373  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P373 {

    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2,
            int k) {

            int m = nums1.length, n = nums2.length;

            if (m == 0 || n == 0) {
                return Collections.emptyList();
            }

            List<List<Integer>> ans = new ArrayList<>();

            int[] indexes = new int[m];

            for (int i = 0; i < k; ++i) {
                int min = Integer.MAX_VALUE, minIndex = -1;
                for (int j = 0; j < m; ++j) {
                    if (indexes[j] == n) {
                        continue;
                    }
                    int sum = nums1[j] + nums2[indexes[j]];
                    if (sum < min) {
                        min = sum;
                        minIndex = j;
                    }
                }
                if (minIndex == -1) {
                    break;
                }
                ans.add(
                    Arrays.asList(nums1[minIndex], nums2[indexes[minIndex]++]));
            }

            return ans;
        }
    }

}
