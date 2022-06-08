package redo.Util.listAndArr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 余定邦
 * @ClassName: Lists
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2020年12月29日
 */
public class Lists {

    public static <T> List<List<T>> copy2D(T[][] arr) {
        List<List<T>> outer = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; ++i) {
            List<T> inner = new ArrayList<T>();
            for (T element : arr[i]) {
                inner.add(element);
            }
            outer.add(inner);
        }
        return outer;
    }

    // 向左移动k位
    public static <T> List<T> rotationLeft(List<T> list, int k) {
        List<T> ans = new ArrayList<>();
        ans.addAll(list.subList(k, list.size()));
        ans.addAll(list.subList(0, k));
        return ans;
    }

}
