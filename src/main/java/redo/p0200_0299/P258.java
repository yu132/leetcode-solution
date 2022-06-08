package redo.p0200_0299;

/**  
 * @ClassName: P258  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P258 {

    class Solution {
        public int addDigits(int num) {
            return (num - 1) % 9 + 1;
        }
    }

}
