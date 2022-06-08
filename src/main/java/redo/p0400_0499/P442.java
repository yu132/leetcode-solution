package redo.p0400_0499;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P442  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月18日  
 *  
 */
public class P442 {

    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < nums.length; ++i) {
                int num = nums[i];
                nums[i] = -1;
                while (num != -1 && nums[num - 1] != num) {
                    int temp = nums[num - 1];
                    nums[num - 1] = num;
                    num = temp;
                }
                if (num != -1) {
                    ans.add(num);
                }
            }

            return ans;
        }
    }

}
