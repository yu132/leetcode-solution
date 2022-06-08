package _1400_1499;

import java.util.ArrayList;

/**  
 * @ClassName: _1417  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月14日  
 *  
 */
public class _1417 {

    class Solution {
        public String reformat(String s) {

            ArrayList<Character> letter = new ArrayList<>();
            ArrayList<Character> number = new ArrayList<>();

            for (char each : s.toCharArray()) {
                if (each >= '0' && each <= '9') {
                    number.add(each);
                } else {
                    letter.add(each);
                }
            }

            if (Math.abs(number.size() - letter.size()) > 1) {
                return "";
            }

            ArrayList<Character> first, second;

            if (letter.size() >= number.size()) {
                first  = letter;
                second = number;
            } else {
                first  = number;
                second = letter;
            }

            StringBuilder sb     = new StringBuilder(s.length());

            boolean       f      = true;

            int           index1 = 0, index2 = 0;
            while (true) {
                if (f) {
                    if (index1 == first.size()) {
                        break;
                    }
                    sb.append(first.get(index1++));
                } else {
                    if (index2 == second.size()) {
                        break;
                    }
                    sb.append(second.get(index2++));
                }
                f = !f;
            }

            return sb.toString();
        }
    }

}
