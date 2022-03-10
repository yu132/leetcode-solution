package redo.Util.ag.rabinKarp;

import java.util.function.BiConsumer;

/**
 * @author 余定邦
 * @ClassName: RabinKarpUtil
 * @Description: 字符串滚动哈希
 * @date 2021年1月11日
 */
public class RabinKarpUtil {

    public static void forEachStrAndHash(String str, int len,
                                         BiConsumer<String, Integer> consumer) {

        int[] hash = rabinKarp(str, len);

        for (int i = 0; i < hash.length; ++i) {
            consumer.accept(str.substring(i, i + len), hash[i]);
        }

    }

    // 注意此方法只能产生'a'-'z'的hash值，如果要产生其他类型的，需要修改startCh
    public static int[] rabinKarp(String str, int len) {
        return rabinKarp(str, len, 29, Integer.MAX_VALUE, 'a');
    }

    // 产生所有长度为len的哈希值
    public static int[] rabinKarp(String str, int len, int base, int mod,
                                  char startCh) {

        long hash = 0, basePowLen = 1;
        for (int i = 0; i < len; ++i) {
            hash = (hash * base + (str.charAt(i) - startCh)) % mod;
            basePowLen = (basePowLen * base) % mod;
        }

        int[] ans = new int[str.length() - len + 1];
        ans[0] = (int) hash;

        for (int i = len; i < str.length(); ++i) {
            hash = (hash * base
                    - (str.charAt(i - len) - startCh) * basePowLen % mod
                    + (str.charAt(i) - startCh) + mod) % mod;
            ans[i - len + 1] = (int) hash;
        }
        return ans;
    }

    // @Test
    // public void test() {
    // String str = "afwueifuwbeaifbsidubhfiawebfibsdifbwieufwae";
    // int mod = Integer.MAX_VALUE;// 1000000007
    // int[] ans = rabinKarp(str, 10, 29, mod);
    // for (int i = 0; i < ans.length; ++i) {
    // System.out.println(ans[i] + " "
    // + rabinKarp(str.substring(i, i + 10), 10, 29, mod)[0]);
    // assertTrue(
    // ans[i] == rabinKarp(str.substring(i, i + 10), 10, 29, mod)[0]);
    // }
    // }

}
