package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1541  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1541 {

    class Solution {
        int left, right, count;

        public int minInsertions(String s) {
            left = 0;
            right = 0;
            count = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    handleRight();
                    ++left;
                } else {
                    ++right;
                }
            }

            handleRight();

            if (left != 0) {
                count += left * 2;// ([))]对于多的左括号，补其所有右括号
            }

            return count;
        }

        private void handleRight() {
            if (right == 0) {
                return;
            }
            int needLeft;
            if (right % 2 == 0) {
                needLeft = right / 2;
            } else {
                count += 1;// ( )[)]由于右括号是奇数，因此需要补齐
                needLeft = (right + 1) / 2;
            }
            if (needLeft > left) {
                count += needLeft - left;
                left = 0;
            } else {
                left -= needLeft;
            }
            right = 0;
            return;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(1, s.minInsertions("(()))"));
        // Assert.assertEquals(0, s.minInsertions("())"));
        Assert.assertEquals(3, s.minInsertions("))())("));
        Assert.assertEquals(12, s.minInsertions("(((((("));
        Assert.assertEquals(5, s.minInsertions(")))))))"));
        Assert.assertEquals(40,
            s.minInsertions("()())()))))))(((()())))))((()()()()()())))))))))((((()((()()))))((((())()()((())()("));
    }

}
