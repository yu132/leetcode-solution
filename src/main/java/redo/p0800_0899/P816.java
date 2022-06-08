package redo.p0800_0899;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import redo.Util.Sets;

/**  
 * @ClassName: P916  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月30日  
 *  
 */
public class P816 {

    class Solution {
        public List<String> ambiguousCoordinates(String S) {
            String s = S.substring(1, S.length() - 1);
            List<String> ans = new ArrayList<>();
            for (int i = 1; i < s.length(); ++i) {
                helper(s, i, ans);
            }
            return ans;
        }

        public void helper(String str, int mid, List<String> ans) {
            for (int i = 0; i < mid; ++i) {

                if (check0X(0, mid, i, str)) {
                    continue;
                }

                if (check0X_(0, i, str) || checkX_X0(0, mid, i, str)) {
                    break;
                }

                for (int j = mid; j < str.length(); ++j) {

                    if (check0X(mid, str.length(), j, str)) {
                        continue;
                    }

                    if (check0X_(mid, j, str)
                        || checkX_X0(mid, str.length(), j, str)) {
                        break;
                    }

                    StringBuilder buf = new StringBuilder(str.length() + 3);

                    buf.append('(');

                    append(buf, str, 0, i, mid);

                    buf.append(',').append(' ');

                    append(buf, str, mid, j, str.length());

                    buf.append(')');

                    ans.add(buf.toString());
                }

            }
        }

        boolean check0X(int base, int end, int index, String str) {
            return base == index && index + 1 != end && str.charAt(base) == '0';
        }

        boolean check0X_(int base, int index, String str) {
            return index == base + 2 && str.charAt(base) == '0';
        }

        boolean checkX_X0(int base, int end, int index, String str) {
            return index == base + 1 && str.charAt(end - 1) == '0';
        }

        void append(StringBuilder buf, String str, int start, int mid,
            int end) {
            if (start == mid) {
                buf.append(str, start, end);
            } else {
                buf.append(str, start, mid).append('.').append(str, mid, end);
            }
        }

    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(
            Sets.asSet("(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"),
            new HashSet<>(s.ambiguousCoordinates("(123)")));
        Assert.assertEquals(Sets.asSet("(0.001, 1)", "(0, 0.011)"),
            new HashSet<>(s.ambiguousCoordinates("(00011)")));
        Assert.assertEquals(
            Sets.asSet("(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)",
                "(0.1, 2.3)", "(0.12, 3)"),
            new HashSet<>(s.ambiguousCoordinates("(0123)")));
        Assert.assertEquals(Sets.asSet("(10, 0)"),
            new HashSet<>(s.ambiguousCoordinates("(100)")));
    }

}
