package _0700_0799;

public class _705 {
	
	class MyHashSet {
		
		private byte[] map = new byte[1000001];
		
		/** Initialize your data structure here. */
		public MyHashSet() {}
		
		public void add(int key) {
			map[key] = 1;
		}
		
		public void remove(int key) {
			map[key] = 0;
		}
		
		/** Returns true if this set contains the specified element */
		public boolean contains(int key) {
			return map[key] == 1;
		}
	}
	
}
