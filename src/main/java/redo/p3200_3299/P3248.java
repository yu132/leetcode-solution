package redo.p3200_3299;

import java.util.List;

public class P3248 {

    class Solution {
        public int finalPositionOfSnake(int n, List<String> commands) {
            int x = 0, y = 0;
            for (String op : commands) {
                switch (op) {
                    case "UP":
                        --x;
                        break;
                    case "RIGHT":
                        ++y;
                        break;
                    case "DOWN":
                        ++x;
                        break;
                    case "LEFT":
                        --y;
                        break;
                }
            }
            return x * n + y;
        }
    }

}
