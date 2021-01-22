package redo.p0000_0099;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P46  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P46 {

    static//

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(0, nums, ans);
            return ans;
        }

        public void backtrack(int now, int[] nums, List<List<Integer>> ans) {
            if (now == nums.length) {
                ans.add(toIntList(nums));
                return;
            }
            for (int i = now; i < nums.length; ++i) {
                int temp = nums[i];
                nums[i] = nums[now];
                nums[now] = temp;
                backtrack(now + 1, nums, ans);
                nums[now] = nums[i];
                nums[i] = temp;
            }
        }

        public static List<Integer> toIntList(int[] nums) {
            List<Integer> ans = new ArrayList<>(nums.length);
            for (int num : nums) {
                ans.add(num);
            }
            return ans;
        }
    }

}
