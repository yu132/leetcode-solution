package redo.p1700_1799;

/**  
 * @ClassName: P1758  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P1758 {

    class Solution {
        public int minOperations(String s) {
            int c1 = 0, c2 = 0;// c1:1010; c2:0101

            int flag = 1;

            for (int i = 0; i < s.length(); ++i, flag ^= 1) {
                c1 += (s.charAt(i) - '0') ^ flag;
                c2 += (s.charAt(i) - '0') ^ flag ^ 1;
            }

            return Math.min(c1, c2);
        }
    }

}
