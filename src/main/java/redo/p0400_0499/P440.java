package redo.p0400_0499;

/**  
 * @ClassName: P440  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月22日  
 *  
 */
public class P440 {

    class Solution {
        public int findKthNumber(int n, int k) {
            int num = 1;
            --k;
            while (k > 0) {
                int step = step(n, num, num + 1);
                if (k >= step) {
                    ++num;
                    k -= step;
                } else {
                    num *= 10;
                    --k;
                }
            }
            return num;
        }

        int step(int n, long low, long high) {
            int count = 0;
            while (low <= n) {
                count += Math.min(n + 1, high) - low;
                low *= 10;
                high *= 10;
            }
            return count;
        }
    }

}
