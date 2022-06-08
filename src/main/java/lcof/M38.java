package lcof;

import java.util.HashSet;
import java.util.Set;

/**  
 * @ClassName: M38  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月19日  
 *  
 */
public class M38 {

    class Solution {
        public String[] permutation(String s) {
            Set<String> set = new HashSet<>(factorial(s.length()));
            helper(0, s.toCharArray(), set);
            return set.toArray(new String[set.size()]);
        }

        public void helper(int index, char[] arr, Set<String> set) {
            if (index == arr.length) {
                set.add(String.valueOf(arr));
            }
            for (int i = index; i < arr.length; ++i) {
                swap(index, i, arr);
                helper(index + 1, arr, set);
                swap(index, i, arr);
            }
        }

        public void swap(int x, int y, char[] arr) {
            char temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }

        public int factorial(int n) {
            int count = 1;
            for (int i = 2; i <= n; ++i) {
                count *= i;
            }
            return count;
        }
    }

}
