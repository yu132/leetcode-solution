package lcof;

/**  
 * @ClassName: M05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月12日  
 *  
 */
public class M05 {

    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            for (char each : s.toCharArray()) {
                if (each == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(each);
                }
            }
            return sb.toString();
        }
    }

}
