package redo.p0900_0999;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P929  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月25日  
 *  
 */
public class P929 {

    class Solution {
        public int numUniqueEmails(String[] emails) {
            Set<String> emailsSet = new HashSet<>();
            for (String email : emails) {
                StringBuilder buf = new StringBuilder(email.length());
                int i = 0;
                for (; i < email.length(); ++i) {
                    if (email.charAt(i) == '.') {
                        continue;
                    } else if (email.charAt(i) == '+') {
                        break;
                    } else if (email.charAt(i) == '@') {
                        break;
                    } else {
                        buf.append(email.charAt(i));
                    }
                }
                while (email.charAt(i) != '@') {
                    ++i;
                }
                buf.append(email.substring(i));
                emailsSet.add(buf.toString());
            }
            return emailsSet.size();
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.numUniqueEmails(new String[] {"test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
        Assert.assertEquals(2, s.numUniqueEmails(new String[] {"a@a", "a@b"}));
        Assert.assertEquals(2, s.numUniqueEmails(new String[] {"a@a", "a1@a"}));
        Assert.assertEquals(2, s.numUniqueEmails(new String[] {"a@a", "a.1@a"}));
        Assert.assertEquals(3, s.numUniqueEmails(
            new String[] {"testemail@leetcode.com", "testemail1@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
