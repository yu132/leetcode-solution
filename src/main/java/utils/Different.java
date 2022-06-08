package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**  
 * @ClassName: Different  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月5日  
 *  
 */
public class Different {

    @SuppressWarnings("unchecked")
    public static <E> List<E>[] different(List<E> list1, List<E> list2) {
        List<E> diff1 = new ArrayList<>();
        List<E> diff2 = new ArrayList<>();

        Set<E>  set1  = new HashSet<>(list1);
        Set<E>  set2  = new HashSet<>(list2);

        for (E each : list1) {
            if (!set2.contains(each)) {
                diff1.add(each);
            }
        }
        for (E each : list2) {
            if (!set1.contains(each)) {
                diff2.add(each);
            }
        }

        return new List[] {diff1, diff2};
    }


}
