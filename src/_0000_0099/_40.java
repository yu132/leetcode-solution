package _0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: _40  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月10日  
 *  
 */
public class _40 {

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            helper(0, 0, -1, candidates, target, new ArrayList<>(), ans);
            return ans;
        }

        public void helper(int index, int sum, int banned, int[] candidates, int target, ArrayList<Integer> now,
            List<List<Integer>> ans) {
            if (sum == target) {
                ArrayList<Integer> copy = new ArrayList<>();
                copy.addAll(now);
                ans.add(copy);
                return;
            } else if (index == candidates.length || sum > target) {
                return;
            }
            helper(index + 1, sum, candidates[index], candidates, target, now, ans);

            if (candidates[index] != banned) {
                now.add(candidates[index]);
                helper(index + 1, sum + candidates[index], -1, candidates, target, now, ans);
                now.remove(now.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _40().new Solution().combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
    }

}
