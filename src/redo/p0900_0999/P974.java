package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P974  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P974 {

    static//

    class Solution {
        public int subarraysDivByK(int[] A, int K) {
            IntFixedCounter counter = new IntFixedCounter(0, K);
            counter.plus1(0);
            int ans = 0, prefix = 0;
            for (int num : A) {
                prefix += num;
                int mod = (prefix % K + K) % K;
                ans += counter.get(mod);
                counter.plus1(mod);
            }
            return ans;
        }

        static class IntFixedCounter {

            int start, arr[];

            IntFixedCounter(int start, int end) {
                this.start = start;
                arr = new int[end - start];
            }

            void plus1(int val) {
                ++arr[val - start];
            }

            int get(int val) {
                return arr[val - start];
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(7, s.subarraysDivByK(new int[] {4, 5, 0, -2, -3, 1}, 5));
    }

}
