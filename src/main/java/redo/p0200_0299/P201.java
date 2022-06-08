package redo.p0200_0299;

/**  
 * @ClassName: P201  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P201 {

    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            while (left < right) {
                right &= right - 1;
            }
            return right;
        }
    }

}
