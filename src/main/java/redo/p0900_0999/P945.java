package redo.p0900_0999;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P945  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月22日  
 *  
 */
public class P945 {

    static//

    class Solution {

        public int minIncrementForUnique(int[] A) {

            if (A.length <= 1) {
                return 0;
            }

            NextHelper nextHelper = new NextHelper(max(A) + A.length + 1);
            int count = 0;
            for (int num : A) {
                int next = nextHelper.findNext(num) - 1;
                count += next - num;
            }
            return count;
        }

        public static int max(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }

        static class NextHelper {
            int[] next;

            NextHelper(int len) {
                next = new int[len];
                Arrays.setAll(next, (x) -> x);
            }

            int findNext(int index) {
                if (next[index] == index) {
                    next[index] = index + 1;
                    return index + 1;
                } else {
                    return next[index] = findNext(next[index]);
                }
            }

        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.minIncrementForUnique(new int[] {1, 2, 2}));
        Assert.assertEquals(6, s.minIncrementForUnique(new int[] {3, 2, 1, 2, 1, 7}));
    }

}
