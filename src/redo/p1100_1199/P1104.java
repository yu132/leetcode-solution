package redo.p1100_1199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1104  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class P1104 {

    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            int nkm1 = Integer.highestOneBit(label), nk = nkm1 << 1;
            List<Integer> ans = new ArrayList<>(32);
            ans.add(label);
            while ((label = next(label, nkm1, nk)) != 1) {
                label /= 2;
                ans.add(label);
                nkm1 >>= 1;
                nk >>= 1;
            }
            Collections.reverse(ans);
            return ans;
        }

        public int next(int n, int nkm1, int nk) {
            return nk - 1 - n + nkm1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(1, 3, 4, 14), s.pathInZigZagTree(14));
        Assert.assertEquals(Arrays.asList(1, 2, 6, 10, 26), s.pathInZigZagTree(26));
    }

}
