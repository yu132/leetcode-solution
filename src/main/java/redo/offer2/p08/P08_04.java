package redo.offer2.p08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P08_04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P08_04 {

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(0, nums, new ArrayList<>(), ans);
            return ans;
        }

        void backtrack(int index, int[] nums, List<Integer> list,
            List<List<Integer>> ans) {
            if (index == nums.length) {
                ans.add(new ArrayList<>(list));
                return;
            }
            backtrack(index + 1, nums, list, ans);
            list.add(nums[index]);
            backtrack(index + 1, nums, list, ans);
            list.remove(list.size() - 1);
        }
    }

}
