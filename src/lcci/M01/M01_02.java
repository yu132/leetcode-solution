package lcci.M01;

/**  
 * @ClassName: M01_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月25日  
 *  
 */
public class M01_02 {

    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            int[] c = new int[26];
            for (int i = 0; i < s1.length(); ++i) {
                ++c[s1.charAt(i) - 'a'];
            }
            for (int i = 0; i < s2.length(); ++i) {
                int temp = --c[s2.charAt(i) - 'a'];
                if (temp < 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
