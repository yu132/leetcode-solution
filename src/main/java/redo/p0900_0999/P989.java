package redo.p0900_0999;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P989  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P989 {

    class Solution {

        int k;
        int[] A;
        int index;

        public List<Integer> addToArrayForm(int[] A, int K) {
            k = K;
            index = A.length - 1;
            this.A = A;
            List<Integer> ans = new ArrayList<>();
            int inc = 0;
            while (true) {
                int digitA = digitA();
                int digitK = digitK();
                int num = digitA + digitK + inc;
                ans.add(num % 10);
                inc = num / 10;
                if (index == -1 && k == 0 && inc == 0) {
                    Collections.reverse(ans);
                    return ans;
                }
            }
        }

        public int digitK() {
            int num = k % 10;
            k /= 10;
            return num;
        }

        public int digitA() {
            if (index >= 0) {
                return A[index--];
            }
            return 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), s.addToArrayForm(new int[] {1, 2, 0, 0}, 34));
        Assert.assertEquals(Arrays.asList(4, 5, 5), s.addToArrayForm(new int[] {2, 7, 4}, 181));
        Assert.assertEquals(Arrays.asList(1, 0, 2, 1), s.addToArrayForm(new int[] {2, 1, 5}, 806));
        Assert.assertEquals(Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            s.addToArrayForm(new int[] {9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
        Assert.assertEquals(Arrays.asList(1, 0, 0, 0, 0, 0), s.addToArrayForm(new int[] {1}, 99999));
        Assert.assertEquals(Arrays.asList(0), s.addToArrayForm(new int[] {0}, 0));
        Assert.assertEquals(Arrays.asList(1, 0, 0), s.addToArrayForm(new int[] {1, 0, 0}, 0));
    }

}
