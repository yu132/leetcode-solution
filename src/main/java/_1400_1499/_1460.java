package _1400_1499;

/**  
 * @ClassName: _1460  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年6月6日  
 *  
 */
public class _1460 {

    class Solution {
        public boolean canBeEqual(int[] target, int[] arr) {
            int[] counter = new int[1001];
            for (int each : target) {
                ++counter[each];
            }
            for (int each : arr) {
                --counter[each];
            }
            for (int each : counter) {
                if (each != 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
