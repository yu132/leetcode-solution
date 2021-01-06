package redo.Util;

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
        int[] chs = new int[26];
        for (char ch : str.toCharArray()) {
            ++chs[ch - 'a'];
        }
        return chs;
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
