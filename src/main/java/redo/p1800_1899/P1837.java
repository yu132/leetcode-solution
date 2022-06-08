package redo.p1800_1899;

/**  
 * @ClassName: P1837  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1837 {

    class Solution {
        public int sumBase(int n, int k) {
            int ans = 0;
            while (n != 0) {
                ans += n % k;
                n /= k;
            }
            return ans;
        }
    }

}
