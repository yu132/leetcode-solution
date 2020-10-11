package lcof;

/**  
 * @ClassName: M56  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月22日  
 *  
 */
public class M56_2 {

    class Solution {
        public int singleNumber(int[] nums) {
            int a = 0, b = 0;
            for (int c : nums) {
                b = b ^ c & ~a;
                a = a ^ c & ~b;
            }
            return b;
        }
    }

}
