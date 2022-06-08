package redo.p0800_0899;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P832  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P832 {

    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            for (int i = 0; i < A.length; ++i) {
                for (int low = 0, high = A[0].length - 1; low < high; ++low, --high) {
                    int temp = A[i][low];
                    A[i][low] = A[i][high] ^ 1;
                    A[i][high] = temp ^ 1;
                }
                if (A[0].length % 2 == 1) {
                    A[i][A[0].length / 2] ^= 1;
                }
            }
            return A;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[1,0,0],[0,1,0],[1,1,1]]", Arrays
            .deepToString(s.flipAndInvertImage(new int[][] {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}})).replaceAll("\\s", ""));
        Assert.assertEquals("[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]",
            Arrays
                .deepToString(
                    s.flipAndInvertImage(new int[][] {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}}))
                .replaceAll("\\s", ""));

    }

}
