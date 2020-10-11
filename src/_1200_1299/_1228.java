package _1200_1299;

/**  
 * @ClassName: _1228  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月1日  
 *  
 */
public class _1228 {

    class Solution {
        public int missingNumber(int[] arr) {
            int dif;
            if (arr[1] - arr[0] > 0) {
                dif = Math.min(arr[1] - arr[0], arr[2] - arr[1]);
            } else if (arr[1] - arr[0] < 0) {
                dif = Math.max(arr[1] - arr[0], arr[2] - arr[1]);
            } else {
                return arr[0];
            }

            for (int i = 0; i < arr.length; ++i) {
                if (arr[i + 1] != arr[i] + dif) {
                    return arr[i] + dif;
                }
            }

            return -1;
        }
    }

}
