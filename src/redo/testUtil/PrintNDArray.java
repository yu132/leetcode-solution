package redo.testUtil;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Test;

/**  
 * @ClassName: PrintNDArray  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class PrintNDArray {

    public static String toString(Object[] arr) {
        return Arrays.deepToString(arr);
        // if (arr.getClass().isArray()) {
        // int len = Array.getLength(arr);
        // if (len == 0) {
        // return "[]";
        // } else {
        // StringBuilder sb = new StringBuilder(len * 10);
        // sb.append("[");
        //
        // for (int i = 0; i < len - 1; ++i) {
        // sb.append(toString(Array.get(arr, i))).append(", ");
        // }
        //
        // sb.append(toString(Array.get(arr, len - 1))).append("]");
        //
        // return sb.toString();
        // }
        // }
        //
        // return arr.toString();
    }

    @Test
    public void test() {
        assertEquals("[[[[1]]],[[[2,3]]],[[[2,3],[1,2,3]]],[[[1]]]]",
            toString(new int[][][][] {{{{1}}}, {{{2, 3}}}, {{{2, 3}, {1, 2, 3}}}, {{{1}}}}).replaceAll("\\s", ""));
    }

    @Test
    public void test2() {
        Object[] arr = new Object[1];
        arr[0] = arr;
        assertEquals("[[...]]", toString(arr).replaceAll("\\s", ""));
    }

}
