package redo.Util;

public class Arrays {

    /**
     * 反转数组中的数据，to是包含的
     *
     * @param array
     * @param from
     * @param to
     */
    public void reverseInclude(char[] array, int from, int to) {
        for (; from < to; ++from, --to) {
            char temp = array[from];
            array[from] = array[to];
            array[to] = temp;
        }
    }

}
