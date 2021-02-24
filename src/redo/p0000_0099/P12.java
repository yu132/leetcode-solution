package redo.p0000_0099;

/**  
 * @ClassName: P12  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月21日  
 *  
 */
public class P12 {

    class Solution {

        char[] symbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        public String intToRoman(int num) {
            int base = 0;
            StringBuilder buf = new StringBuilder(20);
            while (num != 0) {
                append(num % 10, base, buf);
                num /= 10;
                base += 2;
            }
            return buf.reverse().toString();
        }

        void append(int val, int base, StringBuilder buf) {
            if (val <= 3) {
                for (int i = 0; i < val; ++i) {
                    buf.append(symbol[base]);
                }
                return;
            }
            if (val == 4) {
                buf.append(symbol[base + 1]).append(symbol[base]);
                return;
            }

            if (val == 9) {
                buf.append(symbol[base + 2]).append(symbol[base]);
                return;
            }

            for (int i = 5; i < val; ++i) {
                buf.append(symbol[base]);
            }

            buf.append(symbol[base + 1]);
        }
    }

}
