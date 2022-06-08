package redo.p0000_0099;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P78  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P78 {

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(0, new ArrayList<>(), nums, ans);
            return ans;
        }

        void backtrack(int index, List<Integer> list, int[] nums,
            List<List<Integer>> ans) {
            if (index == nums.length) {
                ans.add(new ArrayList<>(list));
                return;
            }

            backtrack(index + 1, list, nums, ans);

            list.add(nums[index]);
            backtrack(index + 1, list, nums, ans);
            list.remove(list.size() - 1);
        }
    }

}
