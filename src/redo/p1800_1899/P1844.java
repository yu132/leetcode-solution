package redo.p1800_1899;

/**  
 * @ClassName: P1844  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1844 {

    class Solution {
        public String replaceDigits(String s) {
            char[] chs = s.toCharArray();
            for (int i = 0; i < s.length() / 2; ++i) {
                chs[i * 2 + 1] = shift(chs[i * 2], chs[i * 2 + 1] - '0');
            }
            return String.valueOf(chs);
        }

        char shift(char ch, int index) {
            return (char)(ch + index);
        }
    }

}
