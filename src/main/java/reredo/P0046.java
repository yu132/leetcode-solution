package reredo;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P46  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月4日  
 *  
 */
public class P0046 {

    class Solution {
        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> ans = new ArrayList<>();

            backtrack(0, nums, ans);

            return ans;
        }

        void backtrack(int index, int[] nums, List<List<Integer>> ans) {

            if (index == nums.length) {
                ans.add(toList(nums));
                return;
            }

            for (int i = index; i < nums.length; ++i) {
                swap(nums, index, i);
                backtrack(index + 1, nums, ans);
                swap(nums, index, i);
            }
        }

        void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }

        List<Integer> toList(int[] nums) {
            List<Integer> ans = new ArrayList<>(nums.length);
            for (int num : nums) {
                ans.add(num);
            }
            return ans;
        }
    }

}
