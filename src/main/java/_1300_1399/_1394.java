package _1300_1399;

/**  
 * @ClassName: _1394  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月5日  
 *  
 */
public class _1394 {

    class Solution {
        public int findLucky(int[] arr) {
            int[] counter = new int[501];

            for (int i = 0; i < arr.length; ++i) {
                ++counter[arr[i]];
            }

            for (int i = 500; i >= 1; --i) {
                if (counter[i] == i) {
                    return i;
                }
            }

            return -1;
        }
    }

}
