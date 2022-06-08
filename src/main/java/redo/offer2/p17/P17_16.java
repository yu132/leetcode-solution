package redo.offer2.p17;

/**  
 * @ClassName: P17_16  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月18日  
 *  
 */
public class P17_16 {

    class Solution {
        public int massage(int[] nums) {
            int acc = 0, nacc = 0;
            for (int num : nums) {
                int temp = acc;
                acc = nacc + num;
                nacc = Math.max(temp, nacc);
            }
            return Math.max(acc, nacc);
        }
    }

}
