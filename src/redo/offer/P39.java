package redo.offer;

/**  
 * @ClassName: P39  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P39 {

    class Solution {
        public int majorityElement(int[] nums) {
            int num = 0, count = 0;
            for (int n : nums) {
                if (count == 0) {
                    num = n;
                    count = 1;
                } else if (n == num) {
                    ++count;
                } else {
                    --count;
                }
            }
            return num;
        }
    }

}
