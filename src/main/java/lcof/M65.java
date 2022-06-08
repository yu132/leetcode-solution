package lcof;

/**  
 * @ClassName: M65  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月24日  
 *  
 */
public class M65 {

    class Solution {
        public int add(int a, int b) {
            return b == 0 ? a : add(a ^ b, (a & b) << 1);
        }
    }

}
