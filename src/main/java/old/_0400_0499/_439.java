package old._0400_0499;

/**  
 * @ClassName: _439  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _439 {

    class Solution {

        private int index = 0;
        private String expression;

        public String parseTernary(String expression) {
            this.expression = expression;
            return helper();
        }

        public String helper() {
            if (index + 1 < expression.length() && expression.charAt(index + 1) == '?') {// 三元
                if (expression.charAt(index) == 'T') {
                    index += 2;
                    String ans = helper();
                    ++index;
                    helper();
                    return ans;
                } else {// if (expression.charAt(index) == 'F')
                    index += 2;
                    helper();
                    ++index;
                    return helper();
                }
            } else {
                return expression.substring(index++, index);
            }
        }


    }

}
