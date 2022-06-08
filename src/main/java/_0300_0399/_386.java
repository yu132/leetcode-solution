package _0300_0399;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _386  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月23日  
 *  
 */
public class _386 {

    class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i < 10; ++i) {
                if (i <= n) {
                    dfs(i, n, ans);
                }
            }
            return ans;
        }

        public void dfs(int num, int n, List<Integer> ans) {
            ans.add(num);
            for (int i = 0; i < 10; ++i) {
                if (num * 10 + i <= n) {
                    dfs(num * 10 + i, n, ans);
                } else {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.err.println(new _386().new Solution().lexicalOrder(121));
    }
}
