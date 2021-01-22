package redo.p1100_1199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1156  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1156 {

    class Solution {
        public int maxRepOpt1(String text) {
            int[] count = countLowercaseLetters(text);
            List<int[]>[] rangesList = charRange(text);

            int max = 0;
            for (int x = 0; x < rangesList.length; ++x) {
                List<int[]> ranges = rangesList[x];

                if (ranges.isEmpty()) {
                    continue;
                }

                for (int i = 1; i < ranges.size(); ++i) {
                    int[] range1 = ranges.get(i - 1);
                    int[] range2 = ranges.get(i);
                    if (range1[1] + 1 == range2[0]) {// 只间隔一个其他字符的区间
                        int sum = range1[1] - range1[0] + range2[1] - range2[0];

                        if (sum == count[x]) {// 这两个区间已经包括所有的本字符了
                            max = Math.max(max, sum);// 只能从某个区间挪一个过来
                        } else {
                            max = Math.max(max, sum + 1);// 从其余地方挪一个过来
                        }
                    } else {
                        max = Math.max(max, range1[1] - range1[0] + 1);
                    }
                }

                int[] lastRange = ranges.get(ranges.size() - 1);
                int lastLen = lastRange[1] - lastRange[0];
                if (lastLen == count[x]) {
                    max = Math.max(max, lastLen);
                } else {
                    max = Math.max(max, lastLen + 1);
                }

            }

            return max;
        }

        public int[] countLowercaseLetters(String str) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                ++count[ch - 'a'];
            }
            return count;
        }

        public List<int[]>[] charRange(String str) {

            @SuppressWarnings("unchecked")
            List<int[]>[] ans = new List[26];

            Arrays.setAll(ans, (x) -> new ArrayList<>());

            for (int i = 0; i < str.length();) {
                int j = i + 1;
                while (j < str.length() && str.charAt(j) == str.charAt(i)) {
                    ++j;
                }
                ans[str.charAt(i) - 'a'].add(new int[] {i, j});
                i = j;
            }

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.maxRepOpt1("aaabaaa"));
        Assert.assertEquals(4, s.maxRepOpt1("aaabbaaa"));
        Assert.assertEquals(5, s.maxRepOpt1("aaaaa"));
        Assert.assertEquals(1, s.maxRepOpt1("abcdef"));
    }

}
