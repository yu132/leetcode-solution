package redo.LCP;

public class LCP51 {

    class Solution {

        int max = -1;

        int[] materials;
        int[][] cookbooks;
        int[][] attribute;
        int limit;

        public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
            this.materials = materials;
            this.cookbooks = cookbooks;
            this.attribute = attribute;
            this.limit = limit;
            helper(0, 0, 0);
            return max;
        }

        void helper(int index, int x, int y) {
            if (index == cookbooks.length) {
                if (y >= limit) {
                    max = Math.max(x, max);
                }
                return;
            }
            helper(index + 1, x, y);

            if (!greaterEquals(materials, cookbooks[index])) {
                return;
            }

            minus(materials, cookbooks[index]);

            helper(index + 1, x + attribute[index][0], y + attribute[index][1]);

            add(materials, cookbooks[index]);
        }

        //长度相等的数组，返回前一个数组是否比后一个数组的每个位置的元素都大或相等
        boolean greaterEquals(int[] arr1, int[] arr2) {
            for (int i = 0; i < arr1.length; ++i) {
                if (arr1[i] < arr2[i]) {
                    return false;
                }
            }
            return true;
        }

        //长度相等的数组，每个位置上相减
        void minus(int[] arr1, int[] arr2) {
            for (int i = 0; i < arr1.length; ++i) {
                arr1[i] -= arr2[i];
            }
        }

        //长度相等的数组，每个位置上相加
        void add(int[] arr1, int[] arr2) {
            for (int i = 0; i < arr1.length; ++i) {
                arr1[i] += arr2[i];
            }
        }
    }

}
