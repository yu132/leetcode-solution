package redo.p0100_0199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P187  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P187 {

    static//

    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {

            if (s.length() <= 10) {
                return Collections.emptyList();
            }

            Map<Data, Integer> counter = new HashMap<>();

            List<String> ans = new ArrayList<>();

            forEachStrAndHash(s, 10, (str, h) -> {
                Data d = new Data(str, h);
                int count = counter.getOrDefault(d, 0) + 1;
                if (count == 2) {
                    ans.add(str);
                }
                counter.put(d, count);
            });

            return ans;
        }

        class Data {
            String str;
            int hash;

            public Data(String str, int hash) {
                super();
                this.str = str;
                this.hash = hash;
            }

            @Override
            public int hashCode() {
                return hash;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Data)) {
                    return false;
                }
                return str.equals(((Data)obj).str);
            }
        }

        public static void forEachStrAndHash(String str, int len,
            BiConsumer<String, Integer> consumer) {

            int[] hash = rabinKarp(str, len);

            for (int i = 0; i < hash.length; ++i) {
                consumer.accept(str.substring(i, i + len), hash[i]);
            }

        }

        public static int[] rabinKarp(String str, int len) {
            return rabinKarp(str, len, 29, Integer.MAX_VALUE);
        }

        // 产生所有长度为len的哈希值
        public static int[] rabinKarp(String str, int len, int base, int mod) {
            long hash = 0, basePowLen = 1;
            for (int i = 0; i < len; ++i) {
                hash = (hash * base + (str.charAt(i) - 'A')) % mod;
                basePowLen = (basePowLen * base) % mod;
            }

            int[] ans = new int[str.length() - len + 1];
            ans[0] = (int)hash;

            for (int i = len; i < str.length(); ++i) {
                hash = (hash * base
                    - (str.charAt(i - len) - 'A') * basePowLen % mod
                    + (str.charAt(i) - 'A') + mod) % mod;
                ans[i - len + 1] = (int)hash;
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList("AAAAACCCCC", "CCCCCAAAAA"),
            s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

}
