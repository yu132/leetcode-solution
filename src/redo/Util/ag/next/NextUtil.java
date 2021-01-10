package redo.Util.ag.next;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: NextUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class NextUtil {

    static class NextHelper {
        int[] next;

        NextHelper(int len) {
            next = new int[len];
            Arrays.setAll(next, (x) -> x);
        }

        int findNext(int index) {
            if (index >= next.length) {
                return -1;
            }
            if (next[index] == index) {
                return index;
            } else {
                return next[index] = findNext(next[index]);
            }
        }

        void use(int index) {
            next[index] = index + 1;
        }
    }



    @Test
    public void test() {
        NextHelper s = new NextHelper(100);
        Assert.assertEquals(5, s.findNext(5));
        s.use(5);
        Assert.assertEquals(6, s.findNext(5));
        for (int i = 6; i <= 88; ++i) {
            s.use(i);
        }
        Assert.assertEquals(89, s.findNext(5));
        s.use(99);
        Assert.assertEquals(-1, s.findNext(99));
    }

}
