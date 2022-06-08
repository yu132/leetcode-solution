package redo.p0300_0399;

/**  
 * @ClassName: P338  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P338 {

    class Solution {
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            for (int i = 1; i <= num; ++i) {
                ans[i] = ans[i & (i - 1)] + 1;
            }
            return ans;
        }
    }

}
