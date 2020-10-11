package _1200_1299;

/**  
 * @ClassName: _1271  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月1日  
 *  
 */
public class _1271 {

    class Solution {
        public String toHexspeak(String num) {
            String str = Long.toHexString(Long.valueOf(num));
            str = str.replaceAll("0", "O");
            str = str.replaceAll("1", "I");
            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) >= '2' && str.charAt(i) <= '9') {
                    return "ERROR";
                }
            }
            return str.toUpperCase();
        }
    }

}
