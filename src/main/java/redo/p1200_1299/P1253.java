package redo.p1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1253  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月12日  
 *  
 */
public class P1253 {

    static//

    class Solution {
        public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            int[] low = new int[colsum.length], up = new int[colsum.length];

            for (int i = 0; i < colsum.length; ++i) {
                if (colsum[i] == 2) {
                    low[i] = 1;
                    up[i] = 1;
                    --upper;
                    --lower;
                    if (upper < 0 || lower < 0) {
                        return Collections.emptyList();
                    }
                }
            }

            for (int i = 0; i < colsum.length; ++i) {
                if (colsum[i] == 1) {
                    if (upper > 0) {
                        up[i] = 1;
                        --upper;
                    } else if (lower > 0) {
                        low[i] = 1;
                        --lower;
                    } else {
                        return Collections.emptyList();
                    }
                }
            }

            if (lower + upper > 0) {
                return Collections.emptyList();
            }

            return Arrays.asList(toIntList(up), toIntList(low));
        }

        public static List<Integer> toIntList(int[] nums) {
            List<Integer> ans = new ArrayList<>(nums.length);
            for (int num : nums) {
                ans.add(num);
            }
            return ans;
        }

        public static int sum(int[] nums, int start, int end) {
            int sum = 0;
            for (int i = start; i < end; ++i) {
                sum += nums[i];
            }
            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(Arrays.asList(1, 1, 0), Arrays.asList(0, 0, 1)),
            s.reconstructMatrix(2, 1, new int[] {1, 1, 1}));

        Assert.assertEquals(Arrays.asList(), s.reconstructMatrix(2, 3, new int[] {2, 2, 1, 1}));

        Assert.assertEquals(
            Arrays.asList(Arrays.asList(1, 1, 1, 0, 1, 0, 0, 1, 0, 0), Arrays.asList(1, 0, 1, 0, 0, 0, 1, 1, 0, 1)),
            s.reconstructMatrix(5, 5, new int[] {2, 1, 2, 0, 1, 0, 1, 2, 0, 1}));

        Assert.assertEquals(Arrays.asList(), s.reconstructMatrix(0, 3, new int[] {2, 1}));

    }

}
