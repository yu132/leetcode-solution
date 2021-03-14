package redo.p0200_0299;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P229  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P229 {

    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int n1 = nums[0], c1 = 0, n2 = nums[0], c2 = 0;

            for (int num : nums) {
                if (n1 == num) {
                    ++c1;
                } else if (n2 == num) {
                    ++c2;
                } else if (c1 == 0) {
                    n1 = num;
                    ++c1;
                } else if (c2 == 0) {
                    n2 = num;
                    ++c2;
                } else {
                    --c1;
                    --c2;
                }
            }

            c1 = c2 = 0;
            for (int num : nums) {
                if (n1 == num) {
                    ++c1;
                } else if (n2 == num) {
                    ++c2;
                }
            }

            List<Integer> ans = new ArrayList<>();

            if (c1 > nums.length / 3) {
                ans.add(n1);
            }
            if (c2 > nums.length / 3) {
                ans.add(n2);
            }

            return ans;
        }
    }

}
