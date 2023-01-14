package old._1500_1599;

/**  
 * @ClassName: _1598  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年10月17日  
 *  
 */
public class _1598 {

    class Solution {
        public int minOperations(String[] logs) {

            int level = 0;

            for (String log : logs) {
                if (log.charAt(1) == '.') {// 一定是 ../

                    level = Math.max(0, level - 1);// level不会低于0的

                } else if (!log.equals("./")) {// 不是停留在当前文件夹
                    ++level;
                }
            }

            return level;
        }
    }

}
