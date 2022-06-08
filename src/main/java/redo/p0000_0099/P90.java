package redo.p0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P90  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P90 {

    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> ans = new ArrayList<>();
            backtrack(0, new ArrayList<>(), nums, new boolean[nums.length],
                ans);

            return ans;
        }


        void backtrack(int index, List<Integer> list, int[] nums,
            boolean[] used, List<List<Integer>> ans) {

            if (index == nums.length) {
                ans.add(new ArrayList<>(list));
                return;
            }

            backtrack(index + 1, list, nums, used, ans);

            if (!(index != 0 && nums[index] == nums[index - 1]
                && !used[index - 1])) {

                list.add(nums[index]);
                used[index] = true;
                backtrack(index + 1, list, nums, used, ans);
                used[index] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
