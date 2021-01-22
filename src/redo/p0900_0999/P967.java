package redo.p0900_0999;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import utils.Sets;

/**  
 * @ClassName: P967  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P967 {

    static//

    class Solution {
        public int[] numsSameConsecDiff(int n, int k) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i <= 9; ++i) {
                helper(0, i, 0, n, k, ans);
            }
            return toIntArray(ans);
        }

        public static int[] toIntArray(List<Integer> list) {
            int[] arr = new int[list.size()];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = list.get(i);
            }
            return arr;
        }

        public void helper(int num, int last, int len, int n, int k, List<Integer> list) {
            if (last < 0 || last > 9) {
                return;
            }
            if (len == n - 1) {
                list.add(num * 10 + last);
                return;
            }
            if (k != 0) {
                helper(num * 10 + last, last - k, len + 1, n, k, list);
            }
            helper(num * 10 + last, last + k, len + 1, n, k, list);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.numsSameConsecDiff(3, 7).length);
        Assert.assertEquals(Sets.asSet(181, 292, 707, 818, 929), Sets.asSet(s.numsSameConsecDiff(3, 7)));
        Assert.assertEquals(Sets.asSet(10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98),
            Sets.asSet(s.numsSameConsecDiff(2, 1)));
        Assert.assertEquals(Sets.asSet(11, 22, 33, 44, 55, 66, 77, 88, 99).size(), s.numsSameConsecDiff(2, 0).length);
        Assert.assertEquals(Sets.asSet(11, 22, 33, 44, 55, 66, 77, 88, 99), Sets.asSet(s.numsSameConsecDiff(2, 0)));
        Assert.assertEquals(Sets.asSet(13, 20, 24, 31, 35, 42, 46, 53, 57, 64, 68, 75, 79, 86, 97),
            Sets.asSet(s.numsSameConsecDiff(2, 2)));
    }
}
