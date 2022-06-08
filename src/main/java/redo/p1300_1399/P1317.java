package redo.p1300_1399;

/**  
 * @ClassName: P1317  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1317 {

    class Solution {
        public int[] getNoZeroIntegers(int n) {
            int[] ans = new int[2];
            int base = 1;
            while (n != 0) {
                int value = n % 10;
                n /= 10;
                if (value == 0 || value == 1) {
                    if (n == 0) {
                        ans[0] += 1 * base;
                        return ans;
                    }
                    value += 10;
                    --n;
                }
                if (value % 2 == 0) {
                    ans[0] += value / 2 * base;
                    ans[1] += value / 2 * base;
                } else {
                    ans[0] += value / 2 * base;
                    ans[1] += (value / 2 + 1) * base;
                }
                base *= 10;
            }
            return ans;
        }
    }

}
