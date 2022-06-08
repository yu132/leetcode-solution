package redo.p0300_0399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P306  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P306 {

    class Solution {
        public boolean isAdditiveNumber(String num) {
            for (int i = 1; i <= num.length() / 2; ++i) {

                String num1 = num.substring(0, i);

                if (num1.startsWith("0") && !num1.equals("0")) {
                    continue;
                }

                for (int j = 1; j <= num.length() / 2; ++j) {
                    if (i + j >= num.length()) {
                        break;
                    }

                    String num2 = num.substring(i, i + j);

                    if (num2.startsWith("0") && !num2.equals("0")) {
                        continue;
                    }

                    if (helper(num1, num2, i + j, num)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean helper(String num1, String num2, int index, String num) {
            String next = sum(num1, num2);
            while (num.startsWith(next, index)) {
                num1 = num2;
                num2 = next;
                index += next.length();
                next = sum(num1, num2);
            }
            return index == num.length();
        }

        String sum(String num1, String num2) {
            StringBuilder buf =
                new StringBuilder(Math.max(num1.length(), num2.length()));

            int inc = 0, index = 0;

            for (; index < num1.length() || index < num2.length() || inc != 0;
                ++index) {

                int val = get(num1, index) + get(num2, index) + inc;
                inc = val / 10;
                buf.append(val % 10);
            }

            return buf.reverse().toString();
        }

        int get(String num, int index) {
            if (index >= num.length()) {
                return 0;
            }
            return num.charAt(num.length() - 1 - index) - '0';
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(true, s.isAdditiveNumber("112358"));
        Assert.assertEquals(false, s.isAdditiveNumber("199001200"));
    }
}
