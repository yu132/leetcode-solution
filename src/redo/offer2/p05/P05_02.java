package redo.offer2.p05;

/**  
 * @ClassName: P05_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P05_02 {

    class Solution {
        public String printBin(double num) {
            double base = 1;
            StringBuilder buf = new StringBuilder(34);
            buf.append('0').append('.');
            for (int i = 0; i < 32 && Double.compare(num, 0) != 0; ++i) {
                base /= 2;
                if (num >= base) {
                    buf.append(1);
                    num -= base;
                } else {
                    buf.append(0);
                }
            }
            if (Double.compare(num, 0) != 0) {
                return "ERROR";
            }
            return buf.toString();
        }
    }

}
