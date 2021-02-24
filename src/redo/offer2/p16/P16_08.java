package redo.offer2.p16;

import utils.StringArray;

/**  
 * @ClassName: P16_08  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月15日  
 *  
 */
public class P16_08 {

    static//

    class Solution {

        final static String[] f1t9 = {"", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine"};

        final static String[] _1x =
            {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        final static String[] x0 = {"", "", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        final static String[] ndigits =
            {"Hundred", "Thousand", "Million", "Billion"};

        public String numberToWords(int num) {
            if (num == 0) {
                return "Zero";
            }

            String _000000000xxx, _000000xxx000 = "", _000xxx000000 = "",
                xxx000000000 = "";

            _000000000xxx = count1000(num % 1000);
            num /= 1000;

            if (num != 0) {
                _000000xxx000 = count1000(num % 1000);
                num /= 1000;
            }

            if (num != 0) {
                _000xxx000000 = count1000(num % 1000);
                num /= 1000;
            }

            if (num != 0) {
                xxx000000000 = count1000(num % 1000);
                num /= 1000;
            }

            StringBuilder buf = new StringBuilder(
                _000000000xxx.length() + _000000xxx000.length()
                    + _000xxx000000.length() + xxx000000000.length());

            if (!xxx000000000.equals("")) {
                buf.append(xxx000000000).append(ndigits[3]).append(' ');
            }

            if (!_000xxx000000.equals("")) {
                buf.append(_000xxx000000).append(ndigits[2]).append(' ');
            }

            if (!_000000xxx000.equals("")) {
                buf.append(_000000xxx000).append(ndigits[1]).append(' ');
            }

            buf.append(_000000000xxx);

            return buf.toString().substring(0, buf.length() - 1);
        }

        String count1000(int n) {

            if (n == 0) {
                return "";
            }

            StringBuilder buf = new StringBuilder(100);
            if (n >= 100) {
                buf.append(f1t9[n / 100]).append(' ').append(ndigits[0])
                    .append(' ');
            }
            n %= 100;
            if (n == 0) {
                return buf.toString();
            }

            if (n >= 20) {
                buf.append(x0[n / 10]).append(' ');
                n %= 10;
            } else if (n >= 10) {
                buf.append(_1x[n - 10]).append(' ');
                return buf.toString();
            }

            if (n > 0) {
                buf.append(f1t9[n]).append(' ');
            }

            return buf.toString();
        }
    }

}
