package redo.p0000_0099;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P39  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P39 {

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates,
            int target) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(0, 0, new ArrayList<>(), candidates, target, ans);
            return ans;
        }

        void backtrack(int index, int sum, List<Integer> list, int[] candidates,
            int target, List<List<Integer>> ans) {
            if (sum == target) {
                ans.add(new ArrayList<>(list));
                return;
            }
            if (sum > target) {
                return;
            }
            for (int i = index; i < candidates.length; ++i) {
                list.add(candidates[i]);
                sum += candidates[i];
                backtrack(i, sum, list, candidates, target, ans);
                sum -= candidates[i];
                list.remove(list.size() - 1);
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("", s.combinationSum(new int[] {2, 3, 6, 7}, 7));
    }

}
