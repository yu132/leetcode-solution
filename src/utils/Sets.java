package utils;

import java.util.HashSet;
import java.util.Set;

/**  
 * @ClassName: Sets  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class Sets {

    @SafeVarargs
    public static <E> Set<E> asSet(E... elements) {
        Set<E> set = new HashSet<>();
        for (E ele : elements) {
            set.add(ele);
        }
        return set;
    }

}
