package old._0200_0299;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _216  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月11日  
 *  
 */
public class _216 {

    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> ans = new ArrayList<>();
            helper(1, n, k, new ArrayList<>(), ans);
            return ans;
        }

        public void helper(int i, int n, int k, List<Integer> now, List<List<Integer>> ans) {
            if (n == 0) {
                if (now.size() == k) {
                    List<Integer> list = new ArrayList<>();
                    list.addAll(now);
                    ans.add(list);
                }
                return;
            } else if (n < 0) {
                return;
            } else if (i == 10) {
                return;
            }
            helper(i + 1, n, k, now, ans);

            now.add(i);
            helper(i + 1, n - i, k, now, ans);
            now.remove(now.size() - 1);
        }
    }

}
