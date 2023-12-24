package redo.Util;

import java.util.List;

public class ListCv {

    int[][] cv2D(List<List<Integer>> list) {
        int[][] outer = new int[list.size()][];
        for (int i = 0; i < list.size(); ++i) {
            List<Integer> innerList = list.get(i);
            int[] inner = new int[innerList.size()];
            for (int j = 0; j < innerList.size(); ++j) {
                inner[j] = innerList.get(j);
            }
            outer[i] = inner;
        }
        return outer;
    }

    int[] cv(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }


}
