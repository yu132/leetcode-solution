package redo.offer2.p01;

/**  
 * @ClassName: P01_04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P01_04 {

    class Solution {
        public boolean canPermutePalindrome(String s) {
            int[] count = new int[128];
            for (char ch : s.toCharArray()) {
                ++count[ch];
            }
            boolean odd = false;
            for (int i = 0; i < 128; ++i) {
                if ((count[i] & 1) != 0) {
                    if (odd) {
                        return false;
                    }
                    odd = true;
                }
            }
            return true;
        }
    }

}
