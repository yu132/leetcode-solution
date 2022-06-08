package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P922  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月24日  
 *  
 */
public class P922 {

    class Solution {
        public int[] sortArrayByParityII(int[] A) {

            int low = 0, high = A.length - 1;
            while (low < A.length && high >= 0) {
                while (low < A.length && !(A[low] % 2 == 0 && low % 2 != 0)) {
                    ++low;
                }
                while (high >= 0 && !(A[high] % 2 == 1 && high % 2 != 1)) {
                    --high;
                }
                if (low >= A.length || high < 0) {
                    break;
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
        Assert.assertArrayEquals(new int[] {4, 5, 2, 7}, s.sortArrayByParityII(new int[] {4, 2, 5, 7}));
        Assert.assertArrayEquals(new int[] {2, 3, 4, 1, 4, 3, 0, 1, 0, 3},
            s.sortArrayByParityII(new int[] {2, 3, 1, 1, 4, 0, 0, 4, 3, 3}));


    }

}
