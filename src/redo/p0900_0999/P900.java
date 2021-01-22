package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P900  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月22日  
 *  
 */
public class P900 {

    class RLEIterator {

        int[] A;
        int index = 0;

        public RLEIterator(int[] A) {
            this.A = A;
        }

        public int next(int n) {
            while (index < A.length && A[index] < n) {
                n -= A[index];
                index += 2;
            }
            if (index >= A.length) {
                return -1;
            }
            A[index] -= n;
            return A[index + 1];
        }
    }



    @Test
    public void test() {
        RLEIterator s = new RLEIterator(new int[] {3, 8, 0, 9, 2, 5});
        Assert.assertEquals(8, s.next(2));
        Assert.assertEquals(8, s.next(1));
        Assert.assertEquals(5, s.next(1));
        Assert.assertEquals(-1, s.next(2));
    }

}
