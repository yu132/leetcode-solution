package redo.p2200_2299;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class P2273 {

    class Solution {
        public List<String> removeAnagrams(String[] words) {
            int len = unique(words, (s1, s2) -> Arrays.equals(countLowercaseLetters(s1), countLowercaseLetters(s2)));
            return Arrays.asList(Arrays.copyOf(words, len));
        }

        public int[] countLowercaseLetters(String str) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                ++count[ch - 'a'];
            }
            return count;
        }

        public <T> int unique(T[] array, BiFunction<T, T, Boolean> isEquals) {
            int now = 0, mid = 0;

            while (++mid != array.length) {
                if (!isEquals.apply(array[now], array[mid])) {
                    array[++now] = array[mid];
                }
            }

            return now + 1;
        }
    }

}
