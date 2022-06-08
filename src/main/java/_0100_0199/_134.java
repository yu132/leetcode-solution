/**
 * @Title: _134.java
 *
 * @Package _0100_0199
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月30日
 *
 */
package _0100_0199;

/**
 * @ClassName: _134
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月30日
 * 
 */
public class _134 {

    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int rest = 0, now = 0, startLoc = 0;
            for (int i = 0; i < gas.length; ++i) {
                now  += gas[i] - cost[i];
                rest += gas[i] - cost[i];
                if (now < 0) {
                    startLoc = i + 1;
                    now      = 0;
                }
            }
            return rest < 0 ? -1 : startLoc;
        }
    }

}
