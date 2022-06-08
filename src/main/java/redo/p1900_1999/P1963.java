package redo.p1900_1999;

public class P1963 {

    class Solution {
        public int minSwaps(String s) {
            int l = 0, ans = 0;

            char[] chs = s.toCharArray();

            for (int i = 0, j = s.length() - 1; i < j; ++i) {
                if (chs[i] == '[') {
                    ++l;
                } else {
                    if (l > 0) {
                        --l;
                    } else {
                        while (chs[j] != '[') {
                            --j;
                        }
                        swap(chs, i, j);
                        ++ans;
                        ++l;
                    }
                }
            }
            return ans;
        }

        void swap(char[] array, int x, int y) {
            char num = array[x];
            array[x] = array[y];
            array[y] = num;
        }
    }

}
