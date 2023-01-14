package old._1000_1099;

/**  
 * @ClassName: _1017  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月4日  
 *  
 */
public class _1017 {

    class Solution {
        public String baseNeg2(int N) {

            if (N == 0) {
                return "0";
            }

            StringBuilder sb = new StringBuilder(20);

            while (N != 0) {
                sb.append(Math.abs(N % 2));
                N = (int)Math.ceil(N / -2.0);
            }

            return sb.reverse().toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new _1017().new Solution().baseNeg2(4));
    }
}
