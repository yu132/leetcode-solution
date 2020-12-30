package redo.Util;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: Lists  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
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

}
