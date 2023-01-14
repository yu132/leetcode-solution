package old._0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: _39  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月9日  
 *  
 */
public class _39 {

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            helper(0, target, 0, candidates, new ArrayList<>(), ans);
            return ans;
        }

        public void helper(int index, int target, int sum, int[] candidates, List<Integer> now,
            List<List<Integer>> ans) {
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.addAll(now);
                ans.add(list);
                return;
            } else if (sum > target) {
                return;
            }
            for (int i = index; i < candidates.length; ++i) {
                sum += candidates[i];
                now.add(candidates[i]);
                helper(i, target, sum, candidates, now, ans);
                sum -= candidates[i];
                now.remove(now.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _39().new Solution().combinationSum(new int[] {2, 3, 5}, 123));
    }

}
