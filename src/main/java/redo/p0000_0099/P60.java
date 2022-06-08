package redo.p0000_0099;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P60  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月11日  
 *  
 */
public class P60 {

    class Solution {
        public String getPermutation(int n, int k) {

            --k;

            int facN = 1;

            for (int i = 2; i < n; ++i) {
                facN *= i;
            }

            int[] arr = new int[n];

            Arrays.setAll(arr, (x) -> x + 1);

            for (int i = 0; i < n - 1; ++i) {
                Arrays.sort(arr, i, arr.length);
                int x = k / facN;
                k %= facN;
                swap(arr, i, i + x);
                if (i != n - 1) {
                    facN /= (n - i - 1);
                }
            }

            StringBuilder buf = new StringBuilder(n);
            for (int x : arr) {
                buf.append(x);
            }
            return buf.toString();
        }

        void swap(int[] arr, int x, int y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("321", s.getPermutation(3, 6));
    }

}
