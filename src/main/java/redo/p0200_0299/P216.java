package redo.p0200_0299;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P216  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P216 {

    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(1, new ArrayList<>(k), 0, k, n, ans);
            return ans;
        }

        void backtrack(int index, List<Integer> list, int sum, int k, int n,
            List<List<Integer>> ans) {
            if (list.size() == k) {
                if (sum == n) {
                    ans.add(new ArrayList<>(list));
                }
                return;
            }
            if (sum > n) {
                return;
            }
            if (index == 10) {
                return;
            }
            backtrack(index + 1, list, sum, k, n, ans);

            list.add(index);
            backtrack(index + 1, list, sum + index, k, n, ans);
            list.remove(list.size() - 1);
        }
    }

}
