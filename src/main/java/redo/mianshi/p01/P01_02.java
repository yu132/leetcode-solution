package redo.mianshi.p01;

/**  
 * @ClassName: P01_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P01_02 {

    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1 == null || s2 == null) {
                return false;
            }
            if (s1.length() != s2.length()) {
                return false;
            }
            int[] count1 = count(s1), count2 = count(s2);
            for (int i = 0; i < 128; ++i) {
                if (count1[i] != count2[i]) {
                    return false;
                }
            }
            return true;
        }

        public int[] count(String s) {
            int[] count = new int[128];
            for (char ch : s.toCharArray()) {
                ++count[ch];
            }
            return count;
        }
    }

}
