package redo.p0800_0899;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P842  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月29日  
 *  
 */
public class P842 {

    static//

    class Solution {
        public List<Integer> splitIntoFibonacci(String S) {

            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i <= S.length() / 3; ++i) {
                int num1 = getNum(S, 0, i + 1);
                if (num1 == -1) {
                    break;
                }

                outer:
                for (int j = i + 1; j <= i + 1 + S.length() / 3; ++j) {
                    int num2 = getNum(S, i + 1, j + 1);
                    if (num2 == -1) {
                        break;
                    }

                    ans.add(num1);
                    ans.add(num2);
                    int index = j + 1;
                    while (index < S.length()) {
                        int next = ans.get(ans.size() - 1) + ans.get(ans.size() - 2);
                        int nextIndex = check(S, index, next);
                        if (nextIndex == -1) {
                            ans.clear();
                            continue outer;
                        }
                        ans.add(next);
                        index = nextIndex;
                    }
                    if (ans.size() == 2) {
                        ans.clear();
                        continue;
                    }
                    return ans;
                }
            }

            return ans;
        }

        int check(String s, int start, int num) {
            int len = len(num);
            if (start + len > s.length()) {
                return -1;
            }
            for (int i = start + len - 1; i >= start; --i) {
                int digit = num % 10;
                num /= 10;
                if (s.charAt(i) - '0' != digit) {
                    return -1;
                }
            }
            return start + len;
        }

        public static int len(int num) {
            if (num == 0) {
                return 1;
            }
            int digits = 0;
            while (num != 0) {
                ++digits;
                num /= 10;
            }
            return digits;
        }

        int getNum(String S, int start, int end) {
            // 长度超过int范围或者是以0开头的数字
            if (end - start >= 11 || (S.charAt(start) == '0' && end - start != 1)) {
                return -1;
            }
            long num = 0;
            for (int i = start; i < end; ++i) {
                num = num * 10 + S.charAt(i) - '0';
            }
            if (num > Integer.MAX_VALUE) {
                return -1;
            }
            return (int)num;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(123, 456, 579), s.splitIntoFibonacci("123456579"));
        Assert.assertEquals(Arrays.asList(1, 1, 2, 3, 5, 8, 13), s.splitIntoFibonacci("11235813"));
        Assert.assertEquals(Arrays.asList(), s.splitIntoFibonacci("112358130"));
        Assert.assertEquals(Arrays.asList(), s.splitIntoFibonacci("0123"));
        Assert.assertEquals(Arrays.asList(11, 0, 11, 11), s.splitIntoFibonacci("1101111"));
        Assert.assertEquals(Arrays.asList(17, 5, 22), s.splitIntoFibonacci("17522"));
        Assert.assertEquals(Arrays.asList(), s.splitIntoFibonacci("1122"));
    }

}
