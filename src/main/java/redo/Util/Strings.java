package redo.Util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author 余定邦
 * @ClassName: Strings
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2020年12月29日
 */
public class Strings {

    //消费字符串中包含完全相同字符的字串的开始和结尾
    void consumeSameCharSubStr(String s, BiConsumer<Integer, Integer> biConsumer) {
        for (int index = 0; index < s.length(); ) {
            int next = indexOfNot(s, index);
            biConsumer.accept(index, next);
            index = next;
        }
    }

    //寻找从start开始的第一个和start不相同的字符，如果后面都相同，则返回s.length()
    int indexOfNot(String s, int start) {
        for (int i = start + 1; i < s.length(); ++i) {
            if (s.charAt(i) != s.charAt(start)) {
                return i;
            }
        }
        return s.length();
    }

    // 用于处理str的计数前缀和
    int[][] prefixCount26(String str) {

        int n = str.length() - 1;

        int[][] prefixCount26 = new int[26][n + 1];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 26; ++j) {
                prefixCount26[j][i + 1] = prefixCount26[j][i] + (str.charAt(i) - 'a' == j ? 1 : 0);
            }
        }

        return prefixCount26;
    }

    int countChar(int[][] prefixCount26, char ch, int start, int end) {
        return prefixCount26[ch - 'a'][end] - prefixCount26[ch - 'a'][start];
    }

    //判定b是否为a的子序列
    boolean isSubSeq(String a, String b) {
        if (b.length() > a.length()) {
            return false;
        }
        for (int indexA = -1, indexB = 0; indexB < b.length(); ++indexB) {
            if ((indexA = a.indexOf(b.charAt(indexB), indexA + 1)) == -1) {
                return false;
            }
        }
        return true;
    }

    String paddingFront(String str, int len, char padChar) {
        if (str.length() >= len) {
            return str;
        }
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < len - str.length(); ++i) {
            buf.append(padChar);
        }
        buf.append(str);
        return buf.toString();
    }

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public int[] countLowercaseLetters(String str) {
        int[] count = new int[26];
        for (char ch : str.toCharArray()) {
            ++count[ch - 'a'];
        }
        return count;
    }

    int[] countNum(String str) {
        int[] count = new int[10];
        for (char ch : str.toCharArray()) {
            ++count[ch - '0'];
        }
        return count;
    }

    boolean isPalindromic(String str) {
        for (int i = 0; i < str.length() / 2; ++i) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 某个字符是否能够从某个位置开始匹配上另一个字符
     *
     * @param strToMatch   被匹配的字符，即该字符从某个位置开始被匹配
     * @param index        位置
     * @param strNeedMatch 需要匹配的字符，该字符需要从某个位置开始在另一个字符串种出现
     * @return 是否匹配成功
     */
    public boolean matchPosition(String strToMatch, int index, String strNeedMatch) {
        if (index + strNeedMatch.length() > strToMatch.length()) {
            return false;
        }
        for (int i = 0; i < strNeedMatch.length(); ++i) {
            if (strToMatch.charAt(i + index) != strNeedMatch.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 重复某个字符产生字符串
     *
     * @param ch
     * @param times
     * @return
     */
    public String repeat(char ch, int times) {
        StringBuilder buf = new StringBuilder(times);
        for (int i = 0; i < times; ++i) {
            buf.append(ch);
        }
        return buf.toString();
    }

    /**
     * 大写第一个字符
     *
     * @param str
     * @return
     */
    public String uppercaseFirstChar(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    /**
     * 使用某个单独字符进行切分，切分后不保留空字符串，即将多个spliter当作一个来处理
     */
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

    public List<int[]> splitAndRemoveEmptyReturnRange(String str, char spliter) {
        int start = 0;
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == spliter) {
                if (start == i) {
                    ++start;
                    continue;
                }

                ans.add(new int[]{start, i});

                start = i + 1;
            }
        }

        if (start != str.length()) {
            ans.add(new int[]{start, str.length()});
        }

        return ans;
    }

    public String valueOf(List<Character> chs) {
        StringBuilder buf = new StringBuilder(chs.size());
        for (char ch : chs) {
            buf.append(ch);
        }
        return buf.toString();
    }

    /**
     * 将每个位置转换为点号后消费，一般用于通配符生成的情况
     *
     * @param str
     * @param consumer
     */
    void asEachPoint(String str, Consumer<String> consumer) {
        char[] chs = str.toCharArray();

        for (int i = 0; i < str.length(); ++i) {
            char temp = chs[i];
            chs[i] = '.';
            consumer.accept(String.valueOf(chs));
            chs[i] = temp;
        }
    }


    @Test
    public void test() {
        assertEquals(Arrays.asList("1", "2", "3", "4"),
                splitAndRemoveEmpty("1 2 3 4", ' '));
        assertEquals(Arrays.asList("1123", "2123", "3123", "4123"),
                splitAndRemoveEmpty("1123 2123 3123 4123", ' '));
        assertEquals(Arrays.asList("1123", "2123", "3123", "4123"),
                splitAndRemoveEmpty("    1123      2123    3123   4123     ", ' '));
    }

}
