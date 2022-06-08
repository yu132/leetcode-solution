package redo.p1700_1799;

/**  
 * @ClassName: P1784  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月28日  
 *  
 */
public class P1784 {

    class Solution {
        public boolean checkOnesSegment(String s) {
            int index = 0;
            while (index < s.length() && s.charAt(index) == '1') {
                ++index;
            }
            while (index < s.length() && s.charAt(index) == '0') {
                ++index;
            }
            return index == s.length();
        }
    }

}
