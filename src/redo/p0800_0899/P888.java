package redo.p0800_0899;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P888  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P888 {

    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            Set<Integer> set = new HashSet<>();
            int[] ll = (A.length >= B.length ? A : B), sl = (ll == A ? B : A);
            int sumll = 0, sumsl = 0;
            for (int num : ll) {
                set.add(num);
                sumll += num;
            }
            for (int num : sl) {
                sumsl += num;
            }
            for (int num : sl) {
                int y = (sumll - sumsl + 2 * num) / 2;
                if (set.contains(y)) {
                    if (sl == A) {
                        return new int[] {num, y};
                    } else {
                        return new int[] {y, num};
                    }
                }
            }
            throw new RuntimeException("answer not exist");
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(Arrs.build("[1,2]"), s.fairCandySwap(Arrs.build("[1,1]"), Arrs.build("[2,2]")));
        Assert.assertArrayEquals(Arrs.build("[1,2]"), s.fairCandySwap(Arrs.build("[1,2]"), Arrs.build("[2,3]")));
        Assert.assertArrayEquals(Arrs.build("[2,3]"), s.fairCandySwap(Arrs.build("[2]"), Arrs.build("[1,3]")));
    }

}
