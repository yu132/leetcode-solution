package repeat;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _78  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月20日  
 *  
 */
public class _78 {

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            helper(0, nums, new ArrayList<>(), ans);
            return ans;
        }

        public void helper(int index, int[] nums, List<Integer> now, List<List<Integer>> ans) {
            if (index == nums.length) {
                List<Integer> list = new ArrayList<>();
                list.addAll(now);
                ans.add(list);
                return;
            }
            helper(index + 1, nums, now, ans);

            now.add(nums[index]);
            helper(index + 1, nums, now, ans);
            now.remove(now.size() - 1);
        }
    }

}
