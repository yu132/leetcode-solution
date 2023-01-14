package redo.mianshi.p05;

/**  
 * @ClassName: P05_07  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P05_07 {

    static//

    class Solution {

        public int exchangeBits(int num) {
            int oddMask = 0X55555555, evenMask = 0XAAAAAAAA;
            return ((num & oddMask) << 1) | ((num & evenMask) >> 1);
        }
    }

}
