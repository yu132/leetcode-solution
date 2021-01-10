package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1414  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1414 {

    static//

    class Solution {

        public final static int[] FIBS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584,
            4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309,
            3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296,
            433494437, 701408733, 1134903170, 1836311903};

        public int findMinFibonacciNumbers(int k) {
            int count = 0, index = FIBS.length - 1;
            while (true) {
                if (k > FIBS[index]) {
                    k -= FIBS[index];
                    ++count;
                } else if (k == FIBS[index]) {
                    return count + 1;
                } else {
                    --index;
                }
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.findMinFibonacciNumbers(7));
        Assert.assertEquals(2, s.findMinFibonacciNumbers(10));
        Assert.assertEquals(3, s.findMinFibonacciNumbers(19));
    }


}
