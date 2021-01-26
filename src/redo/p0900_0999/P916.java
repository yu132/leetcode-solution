package redo.p0900_0999;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P916  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
public class P916 {

    static//

    class Solution {
        public List<String> wordSubsets(String[] A, String[] B) {
            List<String> ans = new ArrayList<>();

            LowercaseLettersCounter maxCounter2Check = new LowercaseLettersCounter("");

            for (int i = 0; i < B.length; ++i) {
                maxCounter2Check.maxMerge(new LowercaseLettersCounter(B[i]));
            }

            for (String str : A) {
                LowercaseLettersCounter counter = new LowercaseLettersCounter(str);
                if (counter.greaterThan(maxCounter2Check)) {
                    ans.add(str);
                }
            }

            return ans;
        }

        static class LowercaseLettersCounter {
            int[] count = new int[26];

            LowercaseLettersCounter(String str) {
                count(str);
            }

            public void count(String str) {
                for (char ch : str.toCharArray()) {
                    ++count[getIndex(ch)];
                }
            }

            public void maxMerge(LowercaseLettersCounter counter) {
                for (int i = 0; i < 26; ++i) {
                    this.count[i] = Math.max(this.count[i], counter.count[i]);
                }
            }

            public int getCount(char ch) {
                return count[getIndex(ch)];
            }

            public boolean greaterThan(LowercaseLettersCounter counter) {
                for (int i = 0; i < 26; ++i) {
                    if (this.count[i] < counter.count[i]) {// 相等也可以
                        return false;
                    }
                }
                return true;
            }

            public void merge(int[] count) {
                for (int i = 0; i < 26; ++i) {
                    this.count[i] += count[i];
                }
            }

            public void merge(LowercaseLettersCounter counter) {
                merge(counter.count);
            }

            private int getIndex(char ch) {
                return ch - 'a';
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList("facebook", "google", "leetcode"),
            s.wordSubsets(new String[] {"amazon", "apple", "facebook", "google", "leetcode"}, new String[] {"e", "o"}));
        Assert.assertEquals(Arrays.asList("apple", "google", "leetcode"),
            s.wordSubsets(new String[] {"amazon", "apple", "facebook", "google", "leetcode"}, new String[] {"l", "e"}));
        Assert.assertEquals(Arrays.asList("facebook", "google"), s
            .wordSubsets(new String[] {"amazon", "apple", "facebook", "google", "leetcode"}, new String[] {"e", "oo"}));
        Assert.assertEquals(Arrays.asList("google", "leetcode"), s.wordSubsets(
            new String[] {"amazon", "apple", "facebook", "google", "leetcode"}, new String[] {"lo", "eo"}));
        Assert.assertEquals(Arrays.asList("facebook", "leetcode"), s.wordSubsets(
            new String[] {"amazon", "apple", "facebook", "google", "leetcode"}, new String[] {"ec", "oc", "ceo"}));
    }


}
