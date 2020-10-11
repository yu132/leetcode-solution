package _0800_0899;

/**  
 * @ClassName: _829  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月23日  
 *  
 */
public class _829 {

    class Solution {
        public int consecutiveNumbersSum(int N) {
            int ans = 0;
            for (int i = 1; N > 0; N -= i, i++)
                if (N % i == 0) {
                    ans += 1;
                }
            return ans;
        }
    }

}
