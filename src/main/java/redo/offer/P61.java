package redo.offer;

/**  
 * @ClassName: P61  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P61 {

    class Solution {
        public boolean isStraight(int[] nums) {
            int min = 13, max = 1, c0 = 0;
            boolean[] contains = new boolean[14];
            for (int num : nums) {
                if (num == 0) {
                    ++c0;
                } else {
                    max = Math.max(max, num);
                    min = Math.min(min, num);
                    if (contains[num]) {
                        return false;
                    }
                    contains[num] = true;
                }
            }

            for (int i = min; i <= max; ++i) {
                if (!contains[i]) {
                    --c0;
                    if (c0 < 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
