package redo.zhousai;

public class P5289 {

    class Solution {

        int min = Integer.MAX_VALUE;

        public int distributeCookies(int[] cookies, int k) {
            backtrack(0, cookies, new int[k]);
            return min;
        }

        void backtrack(int index, int[] cookies, int[] child) {
            if (index == cookies.length) {
                int max = 0;
                for (int i = 0; i < child.length; ++i) {
                    max = Math.max(child[i], max);
                }
                min = Math.min(min, max);
                return;
            }
            for (int i = 0; i < child.length; ++i) {
                child[i] += cookies[index];
                backtrack(index + 1, cookies, child);
                child[i] -= cookies[index];
            }
        }

    }

}
