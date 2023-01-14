package old._0400_0499;

import java.util.List;

/**  
 * @ClassName: _422  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月27日  
 *  
 */
public class _422 {

    class Solution {
        public boolean validWordSquare(List<String> words) {
            if (words == null || words.size() == 0) {
                return true;
            }

            for (int i = 0; i < words.size(); ++i) {
                for (int j = 0; j < words.get(i).length(); ++j) {
                    if (words.size() <= j) {
                        return false;
                    } else if (words.get(i).length() < i) {
                        return false;
                    } else if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

}
