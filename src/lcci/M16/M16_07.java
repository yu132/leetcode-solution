package lcci.M16;

/**  
 * @ClassName: M16_07  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月14日  
 *  
 */
public class M16_07 {

    class Solution {
        public int maximum(int a, int b) {
            long dif = (long)a - b;
            int  k   = (int)(dif >>> 63);
            return a * (k ^ 1) + b * k;
        }
    }

}
