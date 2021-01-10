package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1538  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1358 {

    class Solution {
        // public int numberOfSubstrings(String s) {
        // int res = 0;
        // // 记录 'a', 'b', 'c' 上次出现的位置
        // int[] record = {-1, -1, -1};
        //
        // // 当前为i，对应另外两个字符最后一次出现的索引为j,k
        // // 那么min(j,k)到i中恰好包含至少一个abc，那么对于0到min(j,k)之前的所有字串都可以和min(j,k)到i合并
        // // 因此就会累加上0到min(j,k)的长度，即min(j,k)+1
        // for (int i = 0; i < s.length(); i++) {
        // if (s.charAt(i) == 'a') {
        // res += Math.min(record[1], record[2]) + 1;
        // } else if (s.charAt(i) == 'b') {
        // res += Math.min(record[0], record[2]) + 1;
        // } else {
        // res += Math.min(record[0], record[1]) + 1;
        // }
        // // 更新 'a', 'b', 'c' 最近出现的位置
        // record[s.charAt(i) - 'a'] = i;
        // }
        // return res;
        // }

        public int numberOfSubstrings(String s) {
            int[] count = new int[3];
            int ans = 0;

            for (int i = 0, j = 0; i < s.length(); ++i) {
                ++count[s.charAt(i) - 'a'];
                while (count[0] > 0 && count[1] > 0 && count[2] > 0) {// 如果当前（增长或缩小后）还包含abc
                    ans += s.length() - i;// 对于每个包含abc字符串，右边的字串一定都包含abc
                    --count[s.charAt(j++) - 'a'];// 左边缩小1位
                }
            }

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(10, s.numberOfSubstrings("abcabc"));
        Assert.assertEquals(3, s.numberOfSubstrings("aaacb"));
        Assert.assertEquals(1, s.numberOfSubstrings("abc"));
        Assert.assertEquals(33, s.numberOfSubstrings("aaaabcbcaaa"));
    }

}
