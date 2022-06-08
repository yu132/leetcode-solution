package redo.Util.ag.josephus;

/**  
 * @ClassName: Josephus  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class Josephus {

    // see leetcode offer-62
    int josephus(int num, int m) {
        int f = 0;
        for (int i = 2; i <= num; ++i) {
            f = (m + f) % i;
        }
        return f;
    }

}
