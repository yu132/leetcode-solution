package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P923  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
public class P923 {

    static//

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int threeSumMulti(int[] arr, int target) {
            IntFixedCounter counter = new IntFixedCounter(0, 101);
            for (int num : arr) {
                counter.plus1(num);
            }
            long sum = 0;
            if (target % 3 == 0) {
                long count = counter.get(target / 3);
                sum += count * (count - 1) * (count - 2) / 6;
            }
            for (int i = 0, len = Math.min(100, target / 2); i <= len; ++i) {
                if (target - 2 * i == i) {
                    continue;
                }
                long count1 = counter.get(target - 2 * i);
                if (count1 == 0) {
                    continue;
                }
                long count2 = counter.get(i);
                sum += count1 * count2 * (count2 - 1) / 2;
            }
            for (int i = 0, len = Math.min(100, target); i <= len; ++i) {
                long count1 = counter.get(i);
                for (int j = i + 1, len2 = Math.min(100, target); j <= len2; ++j) {
                    if (target - i - j <= j) {
                        continue;
                    }
                    long count2 = counter.get(j), count3 = counter.get(target - i - j);
                    sum += count1 * count2 * count3;
                }
            }
            return (int)(sum % MOD);
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
        Assert.assertEquals(20, s.threeSumMulti(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
        Assert.assertEquals(12, s.threeSumMulti(new int[] {1, 1, 2, 2, 2, 2}, 5));
        Assert.assertEquals(20, s.threeSumMulti(new int[] {3, 3, 3, 3, 3, 3}, 9));
    }

}
