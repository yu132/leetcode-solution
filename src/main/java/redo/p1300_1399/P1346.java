package redo.p1300_1399;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1346  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1346 {

    class Solution {
        public boolean checkIfExist(int[] arr) {
            Set<Integer> values = new HashSet<>();
            Set<Integer> x2 = new HashSet<>();
            for (int num : arr) {
                if (x2.contains(num) || values.contains(num * 2)) {
                    return true;
                }
                values.add(num);
                x2.add(num * 2);
            }
            return false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.checkIfExist(new int[] {10, 2, 5, 3}));
        Assert.assertEquals(true, s.checkIfExist(new int[] {7, 1, 14, 11}));
        Assert.assertEquals(false, s.checkIfExist(new int[] {3, 1, 7, 11}));
    }

}
