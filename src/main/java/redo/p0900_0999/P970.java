package redo.p0900_0999;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P970  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P970 {

    class Solution {
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            List<Integer> ans = new ArrayList<>();

            for (int i = 1; i <= bound; i *= x) {
                for (int j = 1; j <= bound; j *= y) {
                    if (i + j <= bound) {
                        ans.add(i + j);
                    }
                    if (y == 1) {
                        break;
                    }
                }
                if (x == 1) {
                    break;
                }
            }

            return new ArrayList<>(new HashSet<>(ans));
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(new HashSet<>(Arrays.asList(2, 3, 4, 5, 7, 9, 10)),
            new HashSet<>(s.powerfulIntegers(2, 3, 10)));
        Assert.assertEquals(new HashSet<>(Arrays.asList(2, 4, 6, 8, 10, 14)),
            new HashSet<>(s.powerfulIntegers(3, 5, 15)));

    }

}
