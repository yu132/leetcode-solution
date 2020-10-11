package lcci.M01;

/**  
 * @ClassName: M01_03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月25日  
 *  
 */
public class M01_03 {

    class Solution {
        public String replaceSpaces(String S, int length) {
            StringBuilder sb = new StringBuilder(S.length());
            for (int i = 0; i < length; ++i) {
                if (S.charAt(i) == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(S.charAt(i));
                }
            }
            return sb.toString();
        }
    }

}
