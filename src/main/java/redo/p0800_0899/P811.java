package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;
import utils.Sets;

import java.util.*;

/**
 * @author 余定邦
 * @ClassName: P811
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2020年12月21日
 */
public class P811 {

    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> count = new HashMap<>();
            for (String str : cpdomains) {
                String[] sp1 = str.split(" ");
                int num = Integer.valueOf(sp1[0]);
                String url = sp1[1];
                count.put(url, count.getOrDefault(url, 0) + num);
                int index = -1;
                while ((index = url.indexOf('.', index + 1)) != -1) {
                    String subUrl = url.substring(index + 1);
                    count.put(subUrl, count.getOrDefault(subUrl, 0) + num);
                }
            }

            List<String> ans = new ArrayList<>(count.size());
            for (Map.Entry<String, Integer> entry : count.entrySet()) {
                ans.add(entry.getValue() + " " + entry.getKey());
            }
            return ans;
        }
    }


    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Sets.asSets("9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"),
                new HashSet<>(s.subdomainVisits(new String[]{"9001 discuss.leetcode.com"})));

        Assert.assertEquals(
                Sets.asSets("901 mail.com", "50 yahoo.com", "900 google.mail.com", "5 wiki.org", "5 org", "1 intel.mail.com",
                        "951 com"),
                new HashSet<>(s.subdomainVisits(
                        new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"})));

    }

}
