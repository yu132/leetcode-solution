package redo.p0800_0899;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P822  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月30日  
 *  
 */
public class P822 {

    class Solution {
        public int flipgame(int[] fronts, int[] backs) {
            boolean[] shown = new boolean[2001];
            Set<Integer> banned = new HashSet<>(fronts.length);
            for (int i = 0; i < fronts.length; ++i) {
                if (fronts[i] != backs[i]) {
                    shown[fronts[i]] = true;
                    shown[backs[i]] = true;
                } else {
                    banned.add(fronts[i]);
                }
            }
            for (int i = 1; i <= 2000; ++i) {
                if (shown[i] && !banned.contains(i)) {
                    return i;
                }
            }
            return 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2,
            s.flipgame(new int[] {1, 2, 4, 4, 7}, new int[] {1, 3, 4, 1, 3}));
    }

}
