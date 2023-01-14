package old._0000_0099;

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
            if (nums.length == 0)
                return ans;

            backtracking(ans, new ArrayList<>(), nums, 0);

            return ans;
        }

        public void backtracking(List<List<Integer>> ans, List<Integer> temp, int[] nums, int index) {
            ans.add(new ArrayList<>(temp));

            for (int i = index; i < nums.length; i++) {
                temp.add(nums[i]);
                backtracking(ans, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
