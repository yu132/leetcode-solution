package redo.p1700_1799;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**  
 * @ClassName: P1797  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月11日  
 *  
 */
public class P1797 {

    class AuthenticationManager {

        LinkedHashMap<String, Integer> tokens = new LinkedHashMap<>();
        int timeToLive;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            tokens.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {

            removeExpiredTokens(currentTime);

            if (!tokens.containsKey(tokenId)) {
                return;
            }
            tokens.remove(tokenId);
            tokens.put(tokenId, currentTime + timeToLive);
        }

        public int countUnexpiredTokens(int currentTime) {
            removeExpiredTokens(currentTime);

            return tokens.size();
        }

        void removeExpiredTokens(int currentTime) {
            for (Iterator<Map.Entry<String, Integer>> it =
                tokens.entrySet().iterator(); it.hasNext();) {

                Map.Entry<String, Integer> entry = it.next();

                if (entry.getValue() <= currentTime) {
                    it.remove();
                } else {
                    break;
                }
            }
        }
    }

}
