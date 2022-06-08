package redo.offer;

/**  
 * @ClassName: P65  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P65 {

    class Solution {
        public int add(int a, int b) {
            while (a != 0) {
                int temp = a ^ b;
                a = (a & b) << 1;
                b = temp;
            }
            return b;
        }
    }

}
