package redo.Util.ag.sort;

import org.junit.Test;

import redo.testUtil.SortTest;

/**  
 * @ClassName: InsertionSortUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class InsertionSortUtil {

    public static void insertSort(IntMockArray arr) {
        for (int i = 1; i < arr.size(); ++i) {
            int num = arr.get(i), j = i;
            while (j > 0 && arr.get(j - 1) > num) {
                arr.set(j, arr.get(j - 1));
                --j;
            }
            arr.set(j, num);
        }
    }

    static interface IntMockArray {
        int size();

        int get(int index);

        int set(int index, int val);
    }

    @Test
    public void test() {
        SortTest.test((arr) -> {
            insertSort(new IntMockArray() {

                @Override
                public int size() {
                    return arr.length;
                }

                @Override
                public int get(int index) {
                    return arr[index];
                }

                @Override
                public int set(int index, int val) {
                    return arr[index] = val;
                }

            });
        });
    }

}
