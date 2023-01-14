package redo.mianshi.p01;

/**  
 * @ClassName: P01_09  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P01_09 {

    class Solution {
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            return (s1 + s1).contains(s2);
        }
    }

}
