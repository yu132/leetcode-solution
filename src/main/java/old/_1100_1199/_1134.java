package old._1100_1199;

/**  
 * @ClassName: _1134  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月31日  
 *  
 */
public class _1134 {

    class Solution {
        public boolean isArmstrong(int N) {

            int count = 0;
            int n     = N;
            while (n != 0) {
                n     /= 10;
                count += 1;
            }

            int sum = 0;
            n = N;
            while (n != 0) {
                sum += Math.pow(n % 10, count);
                if (sum > N) {
                    return false;
                }
                n /= 10;
            }

            return sum == N;
        }
    }

}
