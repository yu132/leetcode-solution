package _0200_0299;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _254  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月7日  
 *  
 */
public class _254 {

    class Solution {
        public List<List<Integer>> getFactors(int n) {
            List<List<Integer>> ans = new ArrayList<>();
            if (n <= 1) {
                return ans;
            }
            helper(ans, new ArrayList<>(), n, 2);
            return ans;
        }

        public void helper(List<List<Integer>> ans, List<Integer> now, int n, int start) {
            if (n == 1 && now.size() > 1) {
                ans.add(new ArrayList<>(now));
                return;
            }
            for (int i = start; i <= n; ++i) {
                if (n % i == 0) {
                    now.add(i);
                    helper(ans, now, n / i, i);
                    now.remove(now.size() - 1);
                }
            }
        }
    }

}
