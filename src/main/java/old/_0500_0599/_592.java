package old._0500_0599;

import java.util.ArrayList;

/**  
 * @ClassName: _592  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月1日  
 *  
 */
public class _592 {

    class Solution {
        public String fractionAddition(String expression) {
            ArrayList<int[]> values = new ArrayList<>();

            int              index  = 0;
            while (index != expression.length()) {
                int sign = 1;
                if (expression.charAt(index) == '-') {
                    sign = -1;
                    ++index;
                } else if (expression.charAt(index) == '+') {
                    ++index;
                }
                int num1 = 0;
                while (index != expression.length() && expression.charAt(index) != '/') {
                    num1 = num1 * 10 + expression.charAt(index++) - '0';
                }
                ++index;
                int num2 = 0;
                while (index != expression.length() && expression.charAt(index) >= '0'
                    && expression.charAt(index) <= '9') {
                    num2 = num2 * 10 + expression.charAt(index++) - '0';
                }
                values.add(new int[] {sign * num1, num2});
            }

            for (int i = values.size() - 2; i >= 0; --i) {
                cul(values.get(i), values.get(i + 1));
            }

            int[] ans = values.get(0);
            return ans[0] + "/" + ans[1];
        }

        public int[] cul(int[] a, int[] b) {
            if (a[1] != b[1]) {
                int lcm = lcm(a[1], b[1]);
                a[0] *= lcm / a[1];
                b[0] *= lcm / b[1];
                a[1]  = b[1] = lcm;
            }
            a[0] += b[0];
            int gcd = gcd(Math.abs(a[0]), a[1]);
            a[0] /= gcd;
            a[1] /= gcd;
            return a;
        }

        public int gcd(int m, int n) {
            int r;
            while (n > 0) {
                r = m % n;
                m = n;
                n = r;
            }
            return m;
        }

        public int lcm(int m, int n) {
            return m * n / gcd(m, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _592().new Solution().fractionAddition("5/3+1/3"));
    }
}
