package redo.Util.newcommutil;

import java.util.List;

/**
 * @author Administrator
 */
public class ListsFastUtil {

    /**
     * 求前几个元素的和
     *
     * @param list
     * @param n
     * @return
     */
    public int sumPrevN(List<Integer> list, int n) {
        int sum = 0;
        for (int i = 0; i < Math.min(list.size(), n); ++i) {
            sum += list.get(i);
        }
        return sum;
    }

    /**
     * 求前几个元素的和，返回long类型
     *
     * @param list
     * @param n
     * @return
     */
    public long sumPrevNcL(List<Integer> list, int n) {
        long sum = 0;
        for (int i = 0; i < Math.min(list.size(), n); ++i) {
            sum += list.get(i);
        }
        return sum;
    }


}
