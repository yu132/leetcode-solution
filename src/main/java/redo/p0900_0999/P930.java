package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P930  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
public class P930 {

    static//

    class Solution {
        public int numSubarraysWithSum(int[] A, int S) {
            IntFixedCounter counter = new IntFixedCounter(0, A.length + 1);
            counter.plus1(0);

            int preSum = 0, ans = 0;
            for (int num : A) {
                preSum += num;
                ans += counter.get(preSum - S);
                counter.plus1(preSum);
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

            void add(int val, int count) {
                arr[val - start] += count;
            }

            int get(int val) {
                if (val - start < 0 || val - start >= arr.length) {
                    return 0;
                }
                return arr[val - start];
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.numSubarraysWithSum(new int[] {1, 0, 1, 0, 1}, 2));
    }

}
