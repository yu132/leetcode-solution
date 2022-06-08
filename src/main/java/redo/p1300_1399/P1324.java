package redo.p1300_1399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1324  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1324 {

    class Solution {
        public List<String> printVertically(String s) {
            List<StringBuilder> bufs = new ArrayList<>();

            List<String> sp = splitAndRemoveEmpty(s, ' ');

            for (int i = 0; i < sp.size(); ++i) {
                String str = sp.get(i);
                while (bufs.size() < str.length()) {
                    bufs.add(new StringBuilder(50));
                }
                for (int j = 0; j < str.length(); ++j) {
                    StringBuilder buf = bufs.get(j);
                    while (buf.length() < i) {
                        buf.append(' ');
                    }
                    buf.append(str.charAt(j));
                }
            }

            List<String> ans = new ArrayList<>(bufs.size());
            for (StringBuilder buf : bufs) {
                ans.add(buf.toString());
            }
            return ans;
        }

        public List<String> splitAndRemoveEmpty(String str, char spliter) {
            int start = 0;
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) == spliter) {
                    if (start == i) {
                        ++start;
                        continue;
                    }

                    ans.add(str.substring(start, i));

                    start = i + 1;
                }
            }

            if (start != str.length()) {
                ans.add(str.substring(start));
            }

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList("HAY", "ORO", "WEU"), s.printVertically("HOW ARE YOU"));
        Assert.assertEquals(Arrays.asList("TBONTB", "OEROOE", "   T"), s.printVertically("TO BE OR NOT TO BE"));
        Assert.assertEquals(Arrays.asList("CIC", "OSO", "N M", "T I", "E N", "S G", "T"),
            s.printVertically("CONTEST IS COMING"));

    }

}
