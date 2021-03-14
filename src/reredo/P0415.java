package reredo;

/**  
 * @ClassName: P415  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月3日  
 *  
 */
public class P0415 {

    class Solution {
        public String addStrings(String num1, String num2) {
            int index1 = num1.length() - 1, index2 = num2.length() - 1;

            StringBuilder buf =
                new StringBuilder(Math.max(num1.length(), num2.length()));

            int inc = 0;

            while (index1 >= 0 || index2 >= 0 || inc != 0) {

                int val = get(num1, index1) + get(num2, index2) + inc;

                buf.append(val % 10);

                inc = val / 10;

                --index1;
                --index2;
            }

            return buf.reverse().toString();
        }

        int get(String str, int index) {
            if (index < 0) {
                return 0;
            }
            return str.charAt(index) - '0';
        }
    }

}
