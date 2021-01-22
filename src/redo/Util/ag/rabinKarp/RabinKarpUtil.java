package redo.Util.ag.rabinKarp;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
 * @ClassName: RabinKarpUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class RabinKarpUtil {

    public static int[] rabinKarp(String str, int len) {
        return rabinKarp(str, len, 29, Integer.MAX_VALUE);
    }

    // 产生所有长度为len的哈希值
    public static int[] rabinKarp(String str, int len, int base, int mod) {
        long hash = 0, basePowLen = 1;
        for (int i = 0; i < len; ++i) {
            hash = (hash * base + (str.charAt(i) - 'a')) % mod;
            basePowLen = (basePowLen * base) % mod;
        }

        int[] ans = new int[str.length() - len + 1];
        ans[0] = (int)hash;

        for (int i = len; i < str.length(); ++i) {
            hash = (hash * base - (str.charAt(i - len) - 'a') * basePowLen % mod + (str.charAt(i) - 'a') + mod) % mod;
            ans[i - len + 1] = (int)hash;
        }
        return ans;
    }

    @Test
    public void test() {
        String str = "afwueifuwbeaifbsidubhfiawebfibsdifbwieufwae";
        int mod = Integer.MAX_VALUE;// 1000000007
        int[] ans = rabinKarp(str, 10, 29, mod);
        for (int i = 0; i < ans.length; ++i) {
            System.out.println(ans[i] + " " + rabinKarp(str.substring(i, i + 10), 10, 29, mod)[0]);
            assertTrue(ans[i] == rabinKarp(str.substring(i, i + 10), 10, 29, mod)[0]);
        }
    }

}
