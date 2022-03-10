package redo.p1700_1799;

/**  
 * @ClassName: P1796  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月28日  
 *  
 */
public class P1796 {

    class Solution {
        public int secondHighest(String s) {
            int max = -1, max2 = -1;
            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    int num = ch - '0';
                    if (num > max) {
                        max2 = max;
                        max = num;
                    } else if (num == max) {
                        continue;
                    } else if (num > max2) {
                        max2 = num;
                    }
                }
            }
            return max2;
        }
    }

}
