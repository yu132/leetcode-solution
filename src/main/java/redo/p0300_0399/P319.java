package redo.p0300_0399;

/**  
 * @ClassName: P319  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P319 {

    class Solution {
        public int bulbSwitch(int n) {
            int count = 0;
            for (int i = 1; i * i <= n; ++i, ++count);
            return count;
        }
    }

}
