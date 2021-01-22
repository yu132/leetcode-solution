package redo.p1100_1199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1177  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1177 {

    class Solution {
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            int[] prefix = prefixOdd(s);

            List<Boolean> ans = new ArrayList<>(queries.length);
            for (int[] query : queries) {
                int odd = Integer.bitCount(prefix[query[1] + 1] ^ prefix[query[0]]);
                ans.add(odd <= query[2] * 2 + 1);
            }

            return ans;
        }

        public int[] prefixOdd(String str) {
            int[] prefix = new int[str.length() + 1];
            for (int i = 0; i < str.length(); ++i) {
                prefix[i + 1] = prefix[i] ^ (1 << (str.charAt(i) - 'a'));
            }
            return prefix;
        }
    }

    // class Solution {
    // public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
    // int[][] countPrefix = countLowercaseLettersPrefix(s);
    // List<Boolean> ans = new ArrayList<>(queries.length);
    // for (int[] query : queries) {
    // int odd = 0;
    // for (int i = 0; i < 26; ++i) {
    // if ((countPrefix[query[1] + 1][i] - countPrefix[query[0]][i]) % 2 != 0) {
    // ++odd;
    // }
    // }
    // ans.add(odd <= query[2] * 2 + 1);
    // }
    // return ans;
    // }
    //
    // public int[][] countLowercaseLettersPrefix(String str) {
    // int[][] countPrefix = new int[str.length() + 1][26];
    // for (int i = 0; i < str.length(); ++i) {
    // for (int j = 0; j < 26; ++j) {
    // if (j == str.charAt(i) - 'a') {
    // countPrefix[i + 1][j] = countPrefix[i][j] + 1;
    // } else {
    // countPrefix[i + 1][j] = countPrefix[i][j];
    // }
    // }
    // }
    // return countPrefix;
    // }
    // }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(true, false, false, true, true),
            s.canMakePaliQueries("abcda", Arrs.build2D("[[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]")));
    }

}
