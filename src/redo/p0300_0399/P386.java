package redo.p0300_0399;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P386  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月22日  
 *  
 */
public class P386 {

    class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i <= 9; ++i) {
                dfs(i, n, ans);
            }
            return ans;
        }

        void dfs(int num, int n, List<Integer> ans) {
            if (num > n) {
                return;
            }
            ans.add(num);
            for (int i = 0; i <= 9; ++i) {
                dfs(num * 10 + i, n, ans);
            }
        }
    }

}
