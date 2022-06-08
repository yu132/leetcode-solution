package redo.p0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P40  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月26日  
 *  
 */
public class P40 {

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates,
            int target) {

            Arrays.sort(candidates);

            List<List<Integer>> ans = new ArrayList<>();

            backtrack(0, 0, target, new ArrayList<>(), candidates,
                new boolean[candidates.length], ans);

            return ans;
        }

        void backtrack(int index, int sum, int target, List<Integer> list,
            int[] candidates, boolean[] used, List<List<Integer>> ans) {
            if (index == candidates.length) {
                return;
            }

            backtrack(index + 1, sum, target, list, candidates, used, ans);

            if (index != 0 && candidates[index] == candidates[index - 1]
                && !used[index - 1]) {
                return;
            }

            used[index] = true;
            sum += candidates[index];
            list.add(candidates[index]);
            if (sum == target) {
                ans.add(new ArrayList<>(list));
            } else if (sum < target) {
                backtrack(index + 1, sum, target, list, candidates, used, ans);
            }
            list.remove(list.size() - 1);
            used[index] = false;
        }
    }

}
