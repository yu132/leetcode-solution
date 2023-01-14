package redo.p2500_2599;

public class P2515 {

    class Solution {
        public int closetTarget(String[] words, String target, int startIndex) {
            RepeatedImmutableArray<String> repArr = new RepeatedImmutableArray<>(words);
            int ans = Integer.MAX_VALUE;
            for (int i = startIndex + words.length; i > startIndex; --i) {
                if (repArr.get(i).equals(target)) {
                    ans = Math.min(ans, startIndex + words.length - i);
                    break;
                }
            }
            for (int i = startIndex + words.length; i < startIndex + 2 * words.length; ++i) {
                if (repArr.get(i).equals(target)) {
                    ans = Math.min(ans, i - (startIndex + words.length));
                    break;
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

        class RepeatedImmutableArray<T> {
            T[] arr;

            public RepeatedImmutableArray(T[] arr) {
                this.arr = arr;
            }

            T get(int index) {
                return arr[index % arr.length];
            }
        }
    }

}
