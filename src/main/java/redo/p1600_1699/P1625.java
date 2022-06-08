package redo.p1600_1699;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1625  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1625 {

    static //

    class Solution {

        String min;
        Set<String> visited = new HashSet<>();
        int a, b;

        public String findLexSmallestString(String s, int a, int b) {
            min = s;
            this.a = a;
            this.b = b;
            helper(s);
            return min;
        }

        public void helper(String str) {
            if (visited.contains(str)) {
                return;
            }
            visited.add(str);
            if (str.compareTo(min) < 0) {
                min = str;
            }
            helper(plusOdd(str, a));
            helper(rotate(str, b));
        }

        public String plusOdd(String str, int num) {
            char[] chs = str.toCharArray();
            for (int i = 1; i < str.length(); i += 2) {
                chs[i] = (char)('0' + (chs[i] - '0' + num) % 10);
            }
            return String.valueOf(chs);
        }

        public String rotate(String str, int k) {
            char[] chs = str.toCharArray();
            arrayRotationBackward(chs, 0, chs.length, k);
            return String.valueOf(chs);
        }

        public static void arrayRotationBackward(char[] array, int from, int length, int k) {
            k %= length;
            reverse(array, from, from + length - k - 1);
            reverse(array, from + length - k, from + length - 1);
            reverse(array, from, from + length - 1);
        }

        public static void reverse(char[] array, int from, int to) {
            for (; from < to; ++from, --to) {
                swap(array, from, to);
            }
        }

        public static void swap(char[] array, int x, int y) {
            char num = array[x];
            array[x] = array[y];
            array[y] = num;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals("2050", s.findLexSmallestString("5525", 9, 2));
        Assert.assertEquals("24", s.findLexSmallestString("74", 5, 1));
        Assert.assertEquals("0011", s.findLexSmallestString("0011", 4, 2));
        Assert.assertEquals("00553311", s.findLexSmallestString("43987654", 7, 3));
    }

}
