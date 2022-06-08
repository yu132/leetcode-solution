package redo.p1300_1399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1366  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1366 {

    class Solution {
        public String rankTeams(String[] votes) {
            int n = votes[0].length();
            if (votes.length == 1 || n == 1) {
                return votes[0];
            }
            Map<Character, int[]> map = new HashMap<>();
            for (String vote : votes) {
                for (int i = 0; i < vote.length(); ++i) {
                    char team = vote.charAt(i);
                    map.computeIfAbsent(team, (x) -> new int[n])[i]++;
                }
            }
            List<Map.Entry<Character, int[]>> entryList = new ArrayList<>(map.entrySet());
            Collections.sort(entryList, (a, b) -> {
                for (int i = 0; i < n; ++i) {
                    if (a.getValue()[i] < b.getValue()[i]) {
                        return 1;
                    } else if (a.getValue()[i] > b.getValue()[i]) {
                        return -1;
                    }
                }
                return Character.compare(a.getKey(), b.getKey());
            });
            StringBuilder buf = new StringBuilder(n);
            for (Map.Entry<Character, int[]> entry : entryList) {
                buf.append(entry.getKey());
            }
            return buf.toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("ACB", s.rankTeams(new String[] {"ABC", "ACB", "ABC", "ACB", "ACB"}));
        Assert.assertEquals("XWYZ", s.rankTeams(new String[] {"WXYZ", "XYZW"}));
        Assert.assertEquals("ZMNAGUEDSJYLBOPHRQICWFXTVK", s.rankTeams(new String[] {"ZMNAGUEDSJYLBOPHRQICWFXTVK"}));
        Assert.assertEquals("ABC", s.rankTeams(new String[] {"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"}));
        Assert.assertEquals("M", s.rankTeams(new String[] {"M", "M", "M", "M"}));
    }

}
