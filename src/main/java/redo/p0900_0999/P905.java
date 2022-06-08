package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P905  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月24日  
 *  
 */
public class P905 {

    class Solution {
        public int[] sortArrayByParity(int[] A) {
            int low = 0, high = A.length - 1;
            while (low < high) {
                while (low < high && A[low] % 2 == 0) {
                    ++low;
                }
                while (low < high && A[high] % 2 == 1) {
                    --high;
                }
                int temp = A[low];
                A[low] = A[high];
                A[high] = temp;
                ++low;
                --high;
            }
            return A;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {4, 2, 1, 3}, s.sortArrayByParity(new int[] {3, 1, 2, 4}));
    }

}
