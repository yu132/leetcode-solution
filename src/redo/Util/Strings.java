package redo.Util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author 余定邦
 * @ClassName: Strings
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2020年12月29日
 */
public class Strings {

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
