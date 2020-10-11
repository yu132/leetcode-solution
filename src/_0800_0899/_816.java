package _0800_0899;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _816  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月20日  
 *  
 */
public class _816 {

    class Solution {
        public List<String> ambiguousCoordinates(String S) {

            List<String> ans = new ArrayList<>();

            for (int i = 2; i < S.length() - 1; ++i) {
                List<String> a = helper(S.substring(1, i));
                List<String> b = helper(S.substring(i, S.length() - 1));

                for (int j = 0; j < a.size(); ++j) {
                    for (int k = 0; k < b.size(); ++k) {
                        ans.add("(" + a.get(j) + ", " + b.get(k) + ")");
                    }
                }
            }

            return ans;
        }

        public List<String> helper(String num) {
            List<String> ans = new ArrayList<>();
            if (num.length() == 1 || num.charAt(0) != '0') {
                ans.add(num);
            }
            for (int i = 1; i < num.length(); ++i) {
                String     str = num.substring(0, i) + "." + num.substring(i, num.length());

                BigDecimal d   = new BigDecimal(str);

                if (!str.equals(d.stripTrailingZeros().toPlainString()) || isInteger(d.doubleValue())) {
                    continue;
                }
                ans.add(str);
            }
            return ans;
        }

        public boolean isInteger(double d) {
            return Double.compare((int)d, d) == 0;
        }
    }


    public static void main(String[] args) {
        String     str = "0.00000010";
        BigDecimal d   = new BigDecimal(str);
        System.out.println(d.stripTrailingZeros().toPlainString());
        System.out.println(str.equals(String.format("%f", Double.valueOf(str))));
        System.out.println(new _816().new Solution().helper("000001"));
    }
}
