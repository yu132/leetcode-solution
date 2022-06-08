package lcp;

import java.util.ArrayList;

/**  
 * @ClassName: LCP07  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月20日  
 *  
 */
public class LCP07 {

    class Solution {
        public int numWays(int n, int[][] relation, int k) {
            ArrayList<ArrayList<Integer>> relationList = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                relationList.add(new ArrayList<>());
            }
            for (int i = 0; i < relation.length; ++i) {
                relationList.get(relation[i][0]).add(relation[i][1]);
            }
            return dfs(n - 1, 0, k, relationList);
        }

        public int dfs(int aim, int now, int k, ArrayList<ArrayList<Integer>> relation) {
            if (k == 0) {
                if (aim == now) {
                    return 1;
                } else {
                    return 0;
                }
            }
            int count = 0;
            for (int i = 0; i < relation.get(now).size(); ++i) {
                count += dfs(aim, relation.get(now).get(i), k - 1, relation);
            }
            return count;
        }
    }

}
