package redo.p1400_1499;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1461  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1461 {

    class Solution {
        public boolean hasAllCodes(String s, int k) {

            if (k > s.length() - (k - 1)) {
                return false;
            }

            int val = 0, mask = 1;

            for (int i = 1; i < k; ++i) {
                mask = (mask << 1) | 1;
            }

            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < k; ++i) {
                val = (val << 1) | charAt(s, i);
            }

            set.add(val);

            for (int i = k; i < s.length(); ++i) {
                val = ((val << 1) | charAt(s, i)) & mask;
                set.add(val);
            }

            return set.size() == (int)Math.pow(2, k);
        }

        public int charAt(String s, int index) {
            return s.charAt(index) - '0';
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.hasAllCodes("00110110", 2));
        Assert.assertEquals(true, s.hasAllCodes("00110", 2));
        Assert.assertEquals(true, s.hasAllCodes("0110", 1));
        Assert.assertEquals(false, s.hasAllCodes("0110", 2));
        Assert.assertEquals(false, s.hasAllCodes("0000000001011100", 4));
        Assert.assertEquals(false, s.hasAllCodes("0101", 13));
    }

}
