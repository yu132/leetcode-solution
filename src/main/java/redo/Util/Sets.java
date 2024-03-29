package redo.Util;

import java.util.HashSet;
import java.util.Set;

/**  
 * @ClassName: Sets  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class Sets {

    public static Set<Integer> toSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }

    public static Set<Integer> asSet(int... nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }

    @SafeVarargs
    public static <T> Set<T> asSet(T... nums) {
        Set<T> set = new HashSet<>();
        for (T num : nums) {
            set.add(num);
        }
        return set;
    }

}
