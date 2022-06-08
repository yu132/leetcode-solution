package redo.offer2.p17;

/**  
 * @ClassName: P17_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月15日  
 *  
 */
public class P17_01 {

    class Solution {
        public int add(int a, int b) {
            while (b != 0) {
                int acc = (a & b) << 1;
                a = a ^ b;
                b = acc;
            }
            return a;
        }
    }

}
