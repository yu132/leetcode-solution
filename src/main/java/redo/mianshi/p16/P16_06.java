package redo.mianshi.p16;

import java.util.Arrays;

/**  
 * @ClassName: P16_06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月15日  
 *  
 */
public class P16_06 {

    class Solution {
        public int smallestDifference(int[] a, int[] b) {
            Arrays.sort(a);
            Arrays.sort(b);

            int index1 = 0, index2 = 0, ans = Integer.MAX_VALUE;

            while (index1 != a.length && index2 != b.length) {
                if (a[index1] >= b[index2]) {
                    if (a[index1] - b[index2] >= 0) {
                        ans = Math.min(ans, a[index1] - b[index2]);
                    }
                    ++index2;
                } else {
                    if (b[index2] - a[index1] >= 0) {
                        ans = Math.min(ans, b[index2] - a[index1]);
                    }
                    ++index1;
                }
            }

            return ans;
        }
    }

}
