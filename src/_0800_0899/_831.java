package _0800_0899;

/**  
 * @ClassName: _831  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月2日  
 *  
 */
public class _831 {

    class Solution {
        public String maskPII(String S) {

            int           index = S.indexOf('@');
            StringBuilder sb    = new StringBuilder(S.length());
            if (index >= 0) {// 邮箱
                sb.append(Character.toLowerCase(S.charAt(0)));
                for (int i = 0; i < 5; ++i) {
                    sb.append('*');
                }
                sb.append(Character.toLowerCase(S.charAt(index - 1)));
                sb.append('@').append(S.substring(index + 1).toLowerCase());
                return sb.toString();
            } else {// 电话
                int count = 0;
                for (int i = 0; i < S.length(); ++i) {
                    if (S.charAt(i) >= '0' && S.charAt(i) <= '9') {
                        ++count;
                    }
                }
                if (count > 10) {
                    sb.append('+');
                    for (int i = 0; i < count - 10; ++i) {
                        sb.append('*');
                    }
                    sb.append('-');
                }
                sb.append("***-***-");
                for (int i = 0; i < S.length(); ++i) {
                    if (S.charAt(i) >= '0' && S.charAt(i) <= '9') {
                        --count;
                        if (count < 4) {
                            sb.append(S.charAt(i));
                        }
                    }
                }
                return sb.toString();
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(new _831().new Solution().maskPII("826-(10)12345678"));
    }
}
