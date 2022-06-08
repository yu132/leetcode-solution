package lcci.M01;

/**  
 * @ClassName: M01_09  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月26日  
 *  
 */
public class M01_09 {

    class Solution {
        public boolean isFlipedString(String s1, String s2) {
            return s1.length() == s2.length() && (s2 + s2).contains(s1);
        }
    }

}
