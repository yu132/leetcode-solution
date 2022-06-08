package redo.p2000_2099;

public class P2069 {

    class Robot {

        int[][] arr;
        boolean start = true;
        int index = 0;

        public Robot(int width, int height) {
            arr = new int[2 * (width + height) - 4][3];
            for (int x = 1; x < width; ++x) {
                arr[index++] = new int[]{x, 0, 0};
            }
            for (int y = 1; y < height; ++y) {
                arr[index++] = new int[]{width - 1, y, 1};
            }
            for (int x = width - 2; x >= 0; --x) {
                arr[index++] = new int[]{x, height - 1, 2};
            }
            for (int y = height - 2; y >= 0; --y) {
                arr[index++] = new int[]{0, y, 3};
            }
            index = arr.length - 1;
        }

        public void step(int num) {
            start = false;
            index = (index + num) % arr.length;
        }

        public int[] getPos() {
            return new int[]{arr[index][0], arr[index][1]};
        }

        public String getDir() {
            if (start) {
                return "East";
            }
            switch (arr[index][2]) {
                case 0:
                    return "East";
                case 1:
                    return "North";
                case 2:
                    return "West";
                case 3:
                    return "South";
                default:
                    return "";
            }
        }
    }

}
