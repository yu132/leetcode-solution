package _1500_1599;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _1560  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年8月26日  
 *  
 */
public class _1560 {

    class Solution {
        public List<Integer> mostVisited(int n, int[] rounds) {
            List<Integer> ans = new ArrayList<>(n);
            if (rounds[0] <= rounds[rounds.length - 1]) {
                for (int i = rounds[0]; i <= rounds[rounds.length - 1]; ++i) {
                    ans.add(i);
                }
            } else {
                for (int i = 1; i <= rounds[rounds.length - 1]; ++i) {
                    ans.add(i);
                }
                for (int i = rounds[0]; i <= n; ++i) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }

}
