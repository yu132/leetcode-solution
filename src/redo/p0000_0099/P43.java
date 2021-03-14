package redo.p0000_0099;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P43  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月11日  
 *  
 */
public class P43 {

    class Solution {
        public String multiply(String num1, String num2) {

            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }

            int[] arr = new int[num1.length() + num2.length()];

            int m = num1.length(), n = num2.length();

            for (int i = 0; i < num1.length(); ++i) {
                for (int j = 0; j < num2.length(); ++j) {
                    arr[index(i, j, m, n)] +=
                        (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                }
            }

            merge(arr);

            StringBuilder buf = new StringBuilder(arr.length);

            boolean nZero = false;

            for (int i = arr.length - 1; i >= 0; --i) {
                if (!nZero && arr[i] == 0) {
                    continue;
                }
                nZero = true;
                buf.append(arr[i]);
            }

            return buf.toString();
        }

        void merge(int[] arr) {
            for (int i = 0; i < arr.length - 1; ++i) {
                arr[i + 1] += arr[i] / 10;
                arr[i] %= 10;
            }
        }

        int index(int index1, int index2, int len1, int len2) {
            return (len1 - index1 - 1) + (len2 - index2 - 1);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("56088", s.multiply("123", "456"));
    }

}
