package reredo.rrrd;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P39  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月24日  
 *  
 */
public class P39 {

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates,
            int target) {

            List<List<Integer>> ans = new ArrayList<>();

            backtrack(0, 0, target, candidates, new ArrayList<>(), ans);

            return ans;
        }

        void backtrack(int index, int sum, int target, int[] candidates,
            List<Integer> list, List<List<Integer>> ans) {

            if (sum == target) {
                ans.add(new ArrayList<>(list));
                return;
            }

            if (sum > target) {
                return;
            }

            if (index == candidates.length) {
                return;
            }

            backtrack(index + 1, sum, target, candidates, list, ans);

            list.add(candidates[index]);
            backtrack(index, sum + candidates[index], target, candidates, list,
                ans);
            list.remove(list.size() - 1);
        }
    }

}
