package redo.p1900_1999;

public class P1914 {


    static
            //

    class Solution {
        public int[][] rotateGrid(int[][] grid, int k) {
            IntMockArray[] arr = toIntMockArray(grid);
            for (int i = 0; i < arr.length; ++i) {
                rotate(arr[i], 0, k % arr[i].size(), arr[i].size());
            }
            return grid;
        }

        interface IntMockArray {
            int size();

            int get(int index);

            int set(int index, int val);
        }

        class ArrImpl implements IntMockArray {

            int[][] grid;

            int level;

            int m, n;

            int[][] indexesMapping;

            public ArrImpl(int[][] grid, int level) {
                this.grid = grid;
                this.level = level;
                this.m = grid.length;
                this.n = grid[0].length;
                this.indexesMapping = new int[size()][2];
                int index = 0;
                for (int j = level; j < n - level; ++j, ++index) {
                    indexesMapping[index][0] = level;
                    indexesMapping[index][1] = j;
                }
                for (int i = level + 1; i < m - level; ++i, ++index) {
                    indexesMapping[index][0] = i;
                    indexesMapping[index][1] = n - level - 1;
                }
                for (int j = n - 2 - level; j >= level; --j, ++index) {
                    indexesMapping[index][0] = m - level - 1;
                    indexesMapping[index][1] = j;
                }
                for (int i = m - 2 - level; i >= level + 1; --i, ++index) {
                    indexesMapping[index][0] = i;
                    indexesMapping[index][1] = level;
                }
            }

            @Override
            public int size() {
                return (m + n - 4 * level) * 2 - 4;
            }

            @Override
            public int get(int index) {
                return grid[indexesMapping[index][0]][indexesMapping[index][1]];
            }

            @Override
            public int set(int index, int val) {
                int a = grid[indexesMapping[index][0]][indexesMapping[index][1]];
                grid[indexesMapping[index][0]][indexesMapping[index][1]] = val;
                return 0;
            }
        }

        IntMockArray[] toIntMockArray(int[][] grid) {
            int level = Math.min(grid.length, grid[0].length) / 2;
            IntMockArray[] ans = new IntMockArray[level];
            for (int i = 0; i < level; ++i) {
                ans[i] = new ArrImpl(grid, i);
            }
            return ans;
        }

        void rotate(IntMockArray array, int from, int mid, int to) {
            reverse(array, from, mid - 1);
            reverse(array, mid, to - 1);
            reverse(array, from, to - 1);
        }

        void reverse(IntMockArray array, int from, int to) {
            for (; from < to; ++from, --to) {
                swap(array, from, to);
            }
        }

        void swap(IntMockArray array, int x, int y) {
            int num = array.get(x);
            array.set(x, array.get(y));
            array.set(y, num);
        }
    }


}
