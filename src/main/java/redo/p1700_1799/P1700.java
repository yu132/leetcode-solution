package redo.p1700_1799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1700  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1700 {

    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {
            int n0 = 0, n1 = 0;
            for (int like : students) {
                if (like == 0) {
                    ++n0;
                } else {
                    ++n1;
                }
            }
            for (int sandwiche : sandwiches) {
                if (sandwiche == 0) {
                    if (n0 == 0) {
                        return n1;
                    }
                    --n0;
                } else {
                    if (n1 == 0) {
                        return n0;
                    }
                    --n1;
                }
            }
            return 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.countStudents(new int[] {1, 1, 0, 0}, new int[] {0, 1, 0, 1}));
        Assert.assertEquals(3, s.countStudents(new int[] {1, 1, 1, 0, 0, 1}, new int[] {1, 0, 0, 0, 1, 1}));

    }

}
