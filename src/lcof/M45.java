package lcof;

import java.util.Arrays;

/**  
 * @ClassName: M45  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月21日  
 *  
 */
public class M45 {

    class Solution {

        public int compare(String a, String b) {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            if (a.length() > b.length()) {
                int com = a.substring(0, b.length()).compareTo(b);
                if (com != 0) {
                    return com;
                } else {
                    return compare(a.substring(b.length()), b);
                }
            } else {
                int com = a.compareTo(b.substring(0, a.length()));
                if (com != 0) {
                    return com;
                } else {
                    return compare(a, b.substring(a.length()));
                }
            }
        }

        public String minNumber(int[] nums) {
            String[] strNums = new String[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                strNums[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(strNums, (a, b) -> {
                return compare(a, b);
            });

            int len = 0;
            for (String each : strNums) {
                len += each.length();
            }

            StringBuilder sb = new StringBuilder(len);

            for (String each : strNums) {
                sb.append(each);
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // System.out.println(new M45().new Solution().compare("10", "2"));
        System.out.println(new M45().new Solution().minNumber(new int[] {100, 10, 2}));
    }

}
