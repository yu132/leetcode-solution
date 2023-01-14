package redo.mianshi.p16;

/**  
 * @ClassName: P16_05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月15日  
 *  
 */
public class P16_05 {

    class Solution {
        public int trailingZeroes(int n) {
            int count = 0;
            for (long base = 5; n / base > 0; base *= 5) {
                count += n / base;
            }
            return count;
        }
    }

}
