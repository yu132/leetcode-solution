package redo.p1800_1899;

public class P1860 {

    class Solution {

        public int[] memLeak(int memory1, int memory2) {
            int time = 1;
            for (; ; ++time) {
                if (memory1 >= memory2) {
                    if (memory1 >= time) {
                        memory1 -= time;
                    } else {
                        break;
                    }
                } else {
                    if (memory2 >= time) {
                        memory2 -= time;
                    } else {
                        break;
                    }
                }
            }
            return new int[]{time, memory1, memory2};
        }
    }

}
