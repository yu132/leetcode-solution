package old._0800_0899;

/**  
 * @ClassName: _856  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月7日  
 *  
 */
public class _856 {

    class Solution {

        int index;
        String S;

        public int scoreOfParentheses(String S) {
            index  = 0;
            this.S = S;
            return balance();
        }

        public int balance() {
            if (S.charAt(index) == ')') {// 空串
                return 0;
            } else {
                int count = 0;
                while (index != S.length() && S.charAt(index) == '(') {
                    ++index;// '('
                    int inside = balance();
                    ++index;// ')'
                    count += inside == 0 ? 1 : 2 * inside;
                }
                return count;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _856().new Solution().scoreOfParentheses("(()(()))"));
    }

}
