package redo.p0300_0399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P394  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月26日  
 *  
 */
public class P394 {

    class Solution {

        int index;
        String s;

        public String decodeString(String s) {
            this.s = s;
            index = 0;
            return helper();
        }

        String helper() {
            StringBuilder buf = new StringBuilder();

            while (index < s.length()) {

                if (s.charAt(index) == ']') {
                    ++index;// ']'
                    break;
                }

                if (Character.isDigit(s.charAt(index))) {

                    int num = 0;

                    while (index < s.length()
                        && Character.isDigit(s.charAt(index))) {
                        num = num * 10 + s.charAt(index++) - '0';
                    }

                    ++index;// '['

                    String inner = helper();

                    for (int i = 0; i < num; ++i) {
                        buf.append(inner);
                    }
                } else {
                    buf.append(s.charAt(index++));
                }
            }

            return buf.toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("aaabcbc", s.decodeString("3[a]2[bc]"));
    }

}
