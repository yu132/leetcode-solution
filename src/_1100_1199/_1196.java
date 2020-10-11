package _1100_1199;

import java.util.Arrays;

/**  
 * @ClassName: _1196  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月31日  
 *  
 */
public class _1196 {

    class Solution {
        public int maxNumberOfApples(int[] arr) {

            Arrays.sort(arr);

            int sum = 0;

            for (int i = 0; i < arr.length; ++i) {
                sum += arr[i];
                if (sum > 5000) {
                    return i;
                }
            }

            return arr.length;
        }
    }

}
