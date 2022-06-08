package redo.p1800_1899;

public class P1884 {

    class Solution {
        public int twoEggDrop(int n) {
            return (int) Math.ceil((-1 + Math.sqrt(n * 8 + 1)) / 2);
        }
    }

}
