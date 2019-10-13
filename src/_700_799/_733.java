package _700_799;

public class _733 {
	
	class Solution {
		
		private void dfs(int[][] image, byte[] visited, int x, int y, int newColor, int oldColor) {
			if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
				return;
			}
			if (visited[x * 52 + y] == 1) {
				return;
			}
			visited[x * 52 + y] = 1;
			if (image[x][y] == oldColor) {
				image[x][y] = newColor;
				dfs(image, visited, x + 1, y, newColor, oldColor);
				dfs(image, visited, x - 1, y, newColor, oldColor);
				dfs(image, visited, x, y + 1, newColor, oldColor);
				dfs(image, visited, x, y - 1, newColor, oldColor);
			}
		}
		
		public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
			
			if (image.length == 0) {
				return image;
			}
			
			byte[] visited = new byte[3000];
			
			dfs(image, visited, sr, sc, newColor, image[sr][sc]);
			
			return image;
		}
	}
	
}
