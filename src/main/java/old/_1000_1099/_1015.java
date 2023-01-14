package old._1000_1099;

/**  
 * @ClassName: _1015  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月8日  
 *  
 */
public class _1015 {

    // 设n=p*K+q
    // 则n*10+1=10*p*K+q*10+1;
    // 有n%K=q
    // 有(n*10+1)%K=(10*p*K+q*10+1)%K=(q*10+1)%K
    // 又((n%K)*10+1)%K=(q*10+1)%K
    // 推断出：(n*10+1)%K = ((n%K)*10+1)%K

    class Solution {
        public int smallestRepunitDivByK(int K) {
            if (K % 2 == 0 || K % 5 == 0) {
                return -1;
            }
            int i = 1;
            for (int n = 1; n % K != 0; ++i) {
                n = (n % K) * 10 + 1;
            }
            return i;
        }
    }
}
