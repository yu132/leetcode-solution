package redo.p1800_1899;

/**  
 * @ClassName: P1816  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月11日  
 *  
 */
public class P1816 {

    class Solution {
        public String truncateSentence(String s, int k) {
            for (int count = 0, index = 0; index < s.length(); ++index) {
                if (s.charAt(index) == ' ') {
                    ++count;
                }
                if (count == k) {
                    return s.substring(0, index);
                }
            }
            return s;
        }
    }

}
