package redo.p0800_0899;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P833  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月29日  
 *  
 */
public class P833 {

    static//

    class Solution {
        public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
            StringBuilder buf = new StringBuilder(S.length());

            int[] sortedIndex = indexSort(indexes);

            int indexOfSortedIndexes = 0;
            for (int i = 0; i < S.length(); ++i) {
                if (indexOfSortedIndexes == indexes.length) {
                    buf.append(S.charAt(i));
                    continue;
                }

                int indexOfIndexes = sortedIndex[indexOfSortedIndexes];

                if (i == indexes[indexOfIndexes]) {// 需要检查
                    boolean match = true;

                    String toCheck = sources[indexOfIndexes];

                    for (int j = 0; j < toCheck.length(); ++j) {
                        if (S.charAt(i + j) != toCheck.charAt(j)) {
                            match = false;
                            break;
                        }
                    }
                    if (!match) {
                        buf.append(S, i, i + toCheck.length());
                    } else {
                        buf.append(targets[indexOfIndexes]);
                    }
                    ++indexOfSortedIndexes;
                    i += toCheck.length() - 1;
                } else {
                    buf.append(S.charAt(i));
                }
            }
            return buf.toString();
        }

        static int[] indexSort(int[] arr) {
            int[] indexes = new int[arr.length];
            Arrays.setAll(indexes, (x) -> x);
            sort(indexes, (i, j) -> Integer.compare(arr[i], arr[j]));
            return indexes;
        }

        public static void sort(int[] arr, Comparator<Integer> comparator) {
            Integer[] copy = new Integer[arr.length];
            for (int i = 0; i < arr.length; ++i) {
                copy[i] = arr[i];
            }
            Arrays.sort(copy, comparator);
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = copy[i];
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("eeebffff",
            s.findReplaceString("abcd", new int[] {0, 2}, new String[] {"a", "cd"}, new String[] {"eee", "ffff"}));
        Assert.assertEquals("eeecd",
            s.findReplaceString("abcd", new int[] {0, 2}, new String[] {"ab", "ec"}, new String[] {"eee", "ffff"}));
        Assert.assertEquals("vbfrssozp", s.findReplaceString("vmokgggqzp", new int[] {3, 5, 1},
            new String[] {"kg", "ggq", "mo"}, new String[] {"s", "so", "bfr"}));
    }

}
