package redo.p1900_1999;

/**  
 * @ClassName: P1903  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1903 {

    class Solution {
        public String largestOddNumber(String num) {
            for (int i = num.length() - 1; i >= 0; --i) {
                if (((num.charAt(i) - '0') & 1) == 1) {
                    return num.substring(0, i + 1);
                }
            }
            return "";
        }
    }

}
