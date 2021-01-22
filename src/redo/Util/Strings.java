package redo.Util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**  
 * @ClassName: Strings  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class Strings {

    public String repeat(char ch, int times) {
        StringBuilder buf = new StringBuilder(times);
        for (int i = 0; i < times; ++i) {
            buf.append(ch);
        }
        return buf.toString();
    }

    public String uppercaseFirstChar(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    // 使用某个单独字符进行切分，切分后不保留空字符串，即将多个spliter当作一个来处理
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

    public String valueOf(List<Character> chs) {
        StringBuilder buf = new StringBuilder(chs.size());
        for (char ch : chs) {
            buf.append(ch);
        }
        return buf.toString();
    }



    @Test
    public void test() {
        assertEquals(Arrays.asList("1", "2", "3", "4"), splitAndRemoveEmpty("1 2 3 4", ' '));
        assertEquals(Arrays.asList("1123", "2123", "3123", "4123"), splitAndRemoveEmpty("1123 2123 3123 4123", ' '));
        assertEquals(Arrays.asList("1123", "2123", "3123", "4123"),
            splitAndRemoveEmpty("    1123      2123    3123   4123     ", ' '));
    }

}
