package utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 余定邦
 * @ClassName: Sets
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2020年12月19日
 */
public class Sets {

    @SafeVarargs
    public static <E> Set<E> asSets(E... elements) {
        Set<E> set = new HashSet<>();
        for (E ele : elements) {
            set.add(ele);
        }
        return set;
    }

    public static Set<Integer> asSet(int... elements) {
        Set<Integer> set = new HashSet<>();
        for (int ele : elements) {
            set.add(ele);
        }
        return set;
    }

}
