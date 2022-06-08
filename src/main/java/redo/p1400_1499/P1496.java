package redo.p1400_1499;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1496  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1496 {

    class Solution {
        public boolean isPathCrossing(String path) {
            int x = 0, y = 0;
            Set<Integer> set = new HashSet<>();
            set.add(hashcode(x, y));
            for (char ch : path.toCharArray()) {
                switch (ch) {
                    case 'N':
                        ++y;
                        break;
                    case 'E':
                        ++x;
                        break;
                    case 'S':
                        --y;
                        break;
                    case 'W':
                        --x;
                        break;
                }
                int hashcode = hashcode(x, y);
                if (set.contains(hashcode)) {
                    return true;
                }
                set.add(hashcode);
            }
            return false;
        }

        public int hashcode(int x, int y) {
            return x + 10000 * y;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(false, s.isPathCrossing("NES"));
        Assert.assertEquals(true, s.isPathCrossing("NESWW"));
    }

}
