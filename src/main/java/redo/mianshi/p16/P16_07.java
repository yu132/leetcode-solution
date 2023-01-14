package redo.mianshi.p16;

/**  
 * @ClassName: P16_07  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月15日  
 *  
 */
public class P16_07 {

    class Solution {
        public int maximum(int a, int b) {
            int k = (int)(((long)a - b) >> 63 & 1);
            return k * b + (1 - k) * a;
        }
    }

}
