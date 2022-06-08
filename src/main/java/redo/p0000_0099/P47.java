package redo.p0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P47  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P47 {

    static//

    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            backtrack(0, new boolean[nums.length], nums, ans, new ArrayList<>());
            return ans;
        }

        public void backtrack(int now, boolean[] visited, int[] nums, List<List<Integer>> ans, List<Integer> temp) {
            if (now == nums.length) {
                ans.add(new ArrayList<>(temp));
                return;
            }
            for (int i = 0; i < nums.length; ++i) {
                if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                    continue;
                }
                temp.add(nums[i]);
                visited[i] = true;
                backtrack(now + 1, visited, nums, ans, temp);
                visited[i] = false;
                temp.remove(now);
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
