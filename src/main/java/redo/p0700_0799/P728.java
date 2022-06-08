package redo.p0700_0799;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P728  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P728 {

    class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> ans = new ArrayList<>();

            for (int i = left; i <= right; ++i) {
                if (isSelfDivided(i)) {
                    ans.add(i);
                }
            }

            return ans;
        }

        private boolean isSelfDivided(int n) {
            int x = n;
            while (x != 0) {
                int mod = x % 10;
                if (mod == 0 || n % mod != 0) {
                    return false;
                }
                x /= 10;
            }
            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22), s.selfDividingNumbers(1, 22));
    }

}
