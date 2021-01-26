package redo.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: Chars  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class Chars {

    public int[] countLowercaseLetters(String str) {
        int[] count = new int[26];
        for (char ch : str.toCharArray()) {
            ++count[ch - 'a'];
        }
        return count;
    }

    // 如果只是判断奇偶性，那么就不需要前缀和，直接用位运算存储即可
    public int[] prefixOdd(String str) {
        int[] prefix = new int[str.length() + 1];
        for (int i = 0; i < str.length(); ++i) {
            prefix[i + 1] = prefix[i] ^ (1 << (str.charAt(i) - 'a'));
        }
        return prefix;
    }

    // 判断范围内为奇数的数量
    public int countOdd(int start, int end, int[] prefix) {
        return Integer.bitCount(prefix[start] ^ prefix[end + 1]);
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

    public int[][] countLowercaseLettersPrefix(String str) {
        int[][] countPrefix = new int[str.length() + 1][26];
        for (int i = 0; i < str.length(); ++i) {
            for (int j = 0; j < 26; ++j) {
                if (j == str.charAt(i) - 'a') {
                    countPrefix[i + 1][j] = countPrefix[i][j] + 1;
                } else {
                    countPrefix[i + 1][j] = countPrefix[i][j];
                }
            }
        }
        return countPrefix;
    }

    public int[] countLowercaseLetters(char[] chs) {
        int[] count = new int[26];
        for (char ch : chs) {
            ++count[ch - 'a'];
        }
        return count;
    }

    public int[] countUppercaseLetters(String str) {
        int[] count = new int[26];
        for (char ch : str.toCharArray()) {
            ++count[ch - 'A'];
        }
        return count;
    }

    public boolean isLowercaseVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int mappingLowercaseVowel(char ch) {
        switch (ch) {
            case 'a':
                return 0;
            case 'e':
                return 1;
            case 'i':
                return 2;
            case 'o':
                return 3;
            case 'u':
                return 4;
        }
        throw new RuntimeException("unreachable");
    }

    public boolean[] containChars(String str) {
        boolean[] contains = new boolean[26];
        for (char ch : str.toCharArray()) {
            contains[ch - 'a'] = true;
        }
        return contains;
    }

    static class LowercaseLettersCounter {
        int[] count = new int[26];

        public void count(String str) {
            for (char ch : str.toCharArray()) {
                ++count[getIndex(ch)];
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

        public void maxMerge(LowercaseLettersCounter counter) {
            for (int i = 0; i < 26; ++i) {
                this.count[i] = Math.max(this.count[i], counter.count[i]);
            }
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
