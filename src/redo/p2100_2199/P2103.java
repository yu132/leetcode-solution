package redo.p2100_2199;

public class P2103 {

    class Solution {
        public int countPoints(String rings) {
            Index<Character> indexRGB = new Index<>(new Character[]{'R', 'G', 'B'});
            int[][] counter = new int[10][3];
            for (int i = 0; i < rings.length(); i += 2) {
                ++counter[rings.charAt(i + 1) - '0'][indexRGB.index(rings.charAt(i))];
            }
            int ans = 0;
            for (int i = 0; i < 10; ++i) {
                if (counter[i][0] > 0 && counter[i][1] > 0 & counter[i][2] > 0) {
                    ++ans;
                }
            }
            return ans;
        }

        class Index<T> {
            T[] arr;

            public Index(T[] arr) {
                this.arr = arr;
            }

            int index(T item) {
                for (int i = 0; i < arr.length; ++i) {
                    if (item == arr[i]) {
                        return i;
                    }
                }
                return arr.length;
            }
        }
    }

}
