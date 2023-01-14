package redo.p2400_2499;

import java.util.HashSet;
import java.util.Set;

public class P2424 {

    class LUPrefix {

        Set<Integer> set = new HashSet<>();
        int max = 0;

        public LUPrefix(int n) {
        }

        public void upload(int video) {
            set.add(video);
            while (set.contains(max + 1)) {
                ++max;
            }
        }

        public int longest() {
            return max;
        }
    }

}
