package redo.p0100_0199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: P166  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月26日  
 *  
 */
public class P166 {

    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {

            if (numerator == 0) {
                return "0";
            }

            long num = Math.abs((long)numerator),
                den = Math.abs((long)denominator);

            StringBuilder buf = new StringBuilder();

            if ((numerator ^ denominator) < 0) {
                buf.append('-');
            }

            buf.append(num / den);

            num %= den;

            if (num == 0) {
                return buf.toString();
            }

            buf.append('.');

            Map<Long, Integer> map = new HashMap<>();

            while (num != 0) {

                if (map.containsKey(num)) {

                    int index = map.get(num);

                    buf.insert(index, '(');
                    buf.append(')');

                    break;
                }

                map.put(num, buf.length());

                num *= 10;

                buf.append(num / den);

                num %= den;
            }

            return buf.toString();
        }
    }

}
