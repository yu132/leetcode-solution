package redo.Util.ag.graph.floyd;

/**  
 * @ClassName: FloydUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class FloydUtil {

    static void floyd(int[][] distances, int maxLen) {
        int n = distances.length;
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    int loose = distances[i][k] + distances[k][j];
                    if (loose < maxLen && loose < distances[i][j]) {
                        distances[i][j] = loose;
                    }
                }
            }
        }
    }

}
