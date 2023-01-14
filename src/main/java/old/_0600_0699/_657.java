package old._0600_0699;

public class _657 {
	
	class Solution {
		public boolean judgeCircle(String moves) {
			int	horizontal	= 0;
			int	vertical	= 0;
			
			for (char each : moves.toCharArray()) {
				switch (each) {
					case 'R':
						++horizontal;
						break;
					case 'L':
						--horizontal;
						break;
					case 'U':
						++vertical;
						break;
					case 'D':
						--vertical;
						break;
				}
			}
			
			return horizontal == 0 && vertical == 0;
		}
	}
	
}
