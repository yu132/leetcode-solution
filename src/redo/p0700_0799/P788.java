package redo.p0700_0799;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P788  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P788 {

    static//

    class Solution {

        private final static Set<Integer> DIFF = new HashSet<>(Arrays.asList(2, 5, 6, 9));
        private final static Set<Integer> SAME = new HashSet<>(Arrays.asList(0, 1, 8));

        public int rotatedDigits(int N) {
            int count = 0;

            l:
            for (int i = 1; i <= N; ++i) {
                int diff = 0, num = i;
                while (num != 0) {
                    int digit = num % 10;
                    if (DIFF.contains(digit)) {
                        ++diff;
                    } else if (!SAME.contains(digit)) {
                        continue l;
                    }
                    num /= 10;
                }
                if (diff != 0) {
                    ++count;
                }
            }

            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.rotatedDigits(10));
    }

}
