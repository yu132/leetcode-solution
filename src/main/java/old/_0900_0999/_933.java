package old._0900_0999;

public class _933 {
	
	class RecentCounter {
		
		int[]	record		= new int[10005];
		int		index		= 0;
		int		lastIndex	= 0;
		
		public RecentCounter() {}
		
		public int ping(int t) {
			record[index++]	= t;
			lastIndex		= lowerBound(record, lastIndex, index - lastIndex, t - 3000);
			return index - lastIndex;
		}
		
		public int lowerBound(int[] array, int from, int to, int key) {
			int	first	= from, middle;
			int	half, len;
			len = to;
			
			while (len > 0) {
				half	= len >> 1;
				middle	= first + half;
				if (array[middle] < key) {
					first	= middle + 1;
					len		= len - half - 1;       //���ұ��������в���
				} else
					len = half;            //����������У�����middle���в���
			}
			return first;
		}
	}
	
}
