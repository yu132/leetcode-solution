package redo.Util.ag.sort;

import org.junit.Test;

import redo.testUtil.SortTest;

/**  
 * @ClassName: CountSortUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class CountSortUtil {

    // 必须保证count的和等于len
    public static char[] countSortStr(int[] count, int len) {
        char[] chs = new char[len];
        for (int i = 0, index = 0; i < count.length; ++i) {
            for (int j = 0; j < count[i]; ++j) {
                chs[index] = (char)(i + 'a');
            }
        }
        return chs;
    }

    // test by leetcode-1202
    public static void countSortLowerCase(CharMockArray arr) {
        int[] count = countLowerCase(arr);

        for (int i = 0, index = 0; i < 26; ++i) {
            for (int j = 0; j < count[i]; ++j) {
                arr.set(index++, (char)('a' + i));
            }
        }
    }

    public static int[] countLowerCase(CharMockArray nums) {
        int[] count = new int[26];
        for (int i = 0; i < nums.size(); ++i) {
            ++count[nums.get(i) - 'a'];
        }
        return count;
    }

    static interface CharMockArray {
        int size();

        char get(int index);

        char set(int index, char val);
    }

    public static void countSort(IntMockArray arr, int start, int end) {
        int[] count = count(arr, start, end);

        for (int i = 0, index = 0; i < end - start; ++i) {
            for (int j = 0; j < count[i]; ++j) {
                arr.set(index++, start + i);
            }
        }
    }

    public static int[] count(IntMockArray nums, int start, int end) {
        int[] count = new int[end - start];
        for (int i = 0; i < nums.size(); ++i) {
            ++count[nums.get(i) - start];
        }
        return count;
    }

    static interface IntMockArray {
        int size();

        int get(int index);

        int set(int index, int val);
    }

    @Test
    public void test() {
        SortTest.testWithDataRange((arr) -> {
            countSort(new IntMockArray() {

                @Override
                public int size() {
                    return arr.length;
                }

                @Override
                public int get(int index) {
                    return arr[index];
                }

                @Override
                public int set(int index, int val) {
                    return arr[index] = val;
                }

            }, 0, 101);
        }, 0, 101);
    }

}
