package lcci.M16;

import java.util.Arrays;

/**  
 * @ClassName: M16_06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月14日  
 *  
 */
public class M16_06 {

    class Solution {
        public int smallestDifference(int[] a, int[] b) {
            Arrays.sort(a);
            Arrays.sort(b);

            int indexA = 0, indexB = 0, min = Integer.MAX_VALUE;

            while (indexA != a.length && indexB != b.length) {
                long dif = (long)a[indexA] - b[indexB];
                if (dif == 0) {
                    return 0;
                }

                min = (int)Math.min(min, Math.abs(dif));

                if (dif > 0) {
                    ++indexB;
                } else {
                    ++indexA;
                }
            }

            return min;
        }
    }

}
