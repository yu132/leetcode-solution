package lcci.M08;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: M08_04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月4日  
 *  
 */
public class M08_04 {

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            helper(0, nums, new ArrayList<>(), ans);
            return ans;
        }

        public void helper(int index, int[] nums, ArrayList<Integer> temp, List<List<Integer>> ans) {
            if (index == nums.length) {
                ans.add(new ArrayList<>(temp));
                return;
            }
            temp.add(nums[index]);
            helper(index + 1, nums, temp, ans);
            temp.remove(temp.size() - 1);
            helper(index + 1, nums, temp, ans);
        }
    }

}
