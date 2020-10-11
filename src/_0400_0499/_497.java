package _0400_0499;

import java.util.Random;

/**  
 * @ClassName: _497  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月21日  
 *  
 */
public class _497 {

    class Solution {

        int[] lowX, lengthX, lowY, lengthY, weight;

        Random r = new Random();

        public Solution(int[][] rects) {
            lowX    = new int[rects.length];
            lengthX = new int[rects.length];
            lowY    = new int[rects.length];
            lengthY = new int[rects.length];
            weight  = new int[rects.length];

            for (int i = 0; i < rects.length; ++i) {

                lowX[i]    = rects[i][0];
                lengthX[i] = rects[i][2] - rects[i][0];

                lowY[i]    = rects[i][1];
                lengthY[i] = rects[i][3] - rects[i][1];

                if (i == 0) {
                    weight[0] = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
                } else {
                    weight[i] = weight[i - 1] + (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
                }
            }
        }

        public int[] pick() {
            int num   = r.nextInt(weight[weight.length - 1] + 1);
            int index = lowerBound(weight, 0, weight.length, num);
            return new int[] {r.nextInt(lengthX[index] + 1) + lowX[index], r.nextInt(lengthY[index] + 1) + lowY[index]};
        }

        public int lowerBound(int[] array, int from, int size, int key) {
            int first = from, middle;
            int half, len;
            len = size;

            while (len > 0) {
                half   = len >> 1;
                middle = first + half;
                if (array[middle] < key) {
                    first = middle + 1;
                    len   = len - half - 1; // 在右边子序列中查找
                } else
                    len = half; // 在左边子序列（包含middle）中查找
            }
            return first;
        }
    }

    public static void main(String[] args) {
        Solution s = new _497().new Solution(new int[][] {{0, 1, 1, 2}, {2, 3, 3, 4}, {-1, -1, -1, -1}});
        for (int i = 0; i < 100; ++i) {
            s.pick();
        }
    }

}
