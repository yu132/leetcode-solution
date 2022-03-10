package redo2012_05_29start;

/**  
 * @ClassName: P0415  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年5月30日  
 *  
 */
public class P0415 {

    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder buf =
                new StringBuilder(Math.max(num1.length(), num2.length()) + 1);

            int inc = 0, index = 0;
            while (index < num1.length() || index < num2.length() || inc != 0) {
                int val = get(num1, index) + get(num2, index) + inc;
                buf.append(val % 10);
                inc = val / 10;
                ++index;
            }
            return buf.reverse().toString();
        }

        int get(String str, int index) {
            if (index >= str.length()) {
                return 0;
            }
            return str.charAt(str.length() - index - 1) - '0';
        }
    }

}
