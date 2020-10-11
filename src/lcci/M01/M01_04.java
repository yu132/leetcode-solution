package lcci.M01;

/**  
 * @ClassName: M01_04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月25日  
 *  
 */
public class M01_04 {

    class Solution {
        public boolean canPermutePalindrome(String s) {
            boolean[] f = new boolean[256];
            for (char each : s.toCharArray()) {
                f[each] ^= true;
            }
            boolean f1 = false;
            for (boolean each : f) {
                if (each) {
                    if (f1) {
                        return false;
                    } else {
                        f1 = true;
                    }
                }
            }
            return true;
        }
    }

}
