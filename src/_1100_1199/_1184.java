package _1100_1199;

public class _1184 {
	
	class Solution {
		public int distanceBetweenBusStops(int[] distance, int start, int destination) {
			
			int	i		= start;
			
			int	dis1	= 0, dis2 = 0;
			
			while (i != destination) {
				dis1	+= distance[i++];
				i		%= distance.length;
			}
			while (i != start) {
				dis2	+= distance[i++];
				i		%= distance.length;
			}
			
			return Math.min(dis1, dis2);
		}
	}
	
}
