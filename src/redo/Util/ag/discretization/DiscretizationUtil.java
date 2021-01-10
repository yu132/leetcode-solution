package redo.Util.ag.discretization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: Discretization  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class DiscretizationUtil {

    public static int[] discretize(int[] array) {

        Node[] nodes = new Node[array.length];

        Arrays.setAll(nodes, (i) -> new Node(array[i], i));

        Arrays.sort(nodes, (a, b) -> Integer.compare(a.val, b.val));

        int[] discretizedArray = new int[array.length];

        for (int i = 0; i < discretizedArray.length; ++i) {
            discretizedArray[nodes[i].id] = i;
        }

        return discretizedArray;
    }

    private static class Node {
        int val;
        int id;

        public Node(int val, int id) {
            super();
            this.val = val;
            this.id = id;
        }
    }

    public static void discretizeInplace(int[] array) {

        Node[] nodes = new Node[array.length];

        Arrays.setAll(nodes, (i) -> new Node(array[i], i));

        Arrays.sort(nodes, (a, b) -> Integer.compare(a.val, b.val));

        for (int i = 0; i < array.length; ++i) {
            array[nodes[i].id] = i;
        }
    }

    /**
     * 离散化数组，对于相同的数值，离散化后是相同的结果
     * 
     * @param array
     * @return
     */
    public static int[] discretize2(int[] array) {

        int[] copy = Arrays.copyOf(array, array.length);

        Arrays.sort(copy);

        int uniqueLen = unique(copy);

        int[] discretizedArray = new int[array.length];

        Map<Integer, Integer> indexMap = new HashMap<>((int)(array.length / 0.75));

        for (int i = 0; i < uniqueLen; ++i) {
            indexMap.put(copy[i], i);
        }

        for (int i = 0; i < array.length; ++i) {
            discretizedArray[i] = indexMap.get(array[i]);
        }

        return discretizedArray;
    }

    public static void discretize2Inplace(int[] array) {

        int[] copy = Arrays.copyOf(array, array.length);

        Arrays.sort(copy);

        int uniqueLen = unique(copy);

        Map<Integer, Integer> indexMap = new HashMap<>((int)(array.length / 0.75));

        for (int i = 0; i < uniqueLen; ++i) {
            indexMap.put(copy[i], i);
        }

        for (int i = 0; i < array.length; ++i) {
            array[i] = indexMap.get(array[i]);
        }
    }

    public static int unique(int[] array) {
        int now = 0, mid = 0;

        while (++mid != array.length)
            if (array[now] != array[mid])
                array[++now] = array[mid];

        return now + 1;
    }

}
