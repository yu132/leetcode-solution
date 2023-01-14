package redo.zhousai;

import model.ListNode;

import java.util.function.BiConsumer;

public class P6111 {

    class Solution {
        public int[][] spiralMatrix(int m, int n, ListNode head) {
            int[][] arr = new int[m][n];
            ListNode[] temp = new ListNode[1];
            temp[0] = head;
            spiralOrder(m, n, (i, j) -> {
                if (temp[0] != null) {
                    arr[i][j] = temp[0].val;
                    temp[0] = temp[0].next;
                } else {
                    arr[i][j] = -1;
                }
            });
            return arr;
        }

        void spiralOrder(int m, int n, BiConsumer<Integer, Integer> consumer) {
            int top = 0, bottom = m - 1, left = 0, right = n - 1, eleNum = m * n;
            while (eleNum >= 1) {
                for (int i = left; i <= right && eleNum >= 1; ++i) {
                    consumer.accept(top, i);
                    --eleNum;
                }
                ++top;
                for (int i = top; i <= bottom && eleNum >= 1; ++i) {
                    consumer.accept(i, right);
                    --eleNum;
                }
                --right;
                for (int i = right; i >= left && eleNum >= 1; --i) {
                    consumer.accept(bottom, i);
                    --eleNum;
                }
                --bottom;
                for (int i = bottom; i >= top && eleNum >= 1; --i) {
                    consumer.accept(i, left);
                    --eleNum;
                }
                ++left;
            }
        }
    }


}
