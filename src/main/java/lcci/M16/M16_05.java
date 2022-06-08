package lcci.M16;

/**  
 * @ClassName: M16_05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月14日  
 *  
 */
public class M16_05 {

    class Solution {
        public int trailingZeroes(int n) {

            int count = 0;
            while (n != 0) {
                count += n / 5;
                n     /= 5;
            }

            return count;
        }
    }

}
