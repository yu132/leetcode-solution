package old._0700_0799;

public class _706 {
	
	class MyHashMap {
		
		private byte[]	keys	= new byte[1000001];
		private int[]	values	= new int[1000001];
		
		/** Initialize your data structure here. */
		public MyHashMap() {}
		
		/** value will always be non-negative. */
		public void put(int key, int value) {
			keys[key]	= 1;
			values[key]	= value;
		}
		
		/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
		public int get(int key) {
			return keys[key] == 1 ? values[key] : -1;
		}
		
		/** Removes the mapping of the specified value key if this map contains a mapping for the key */
		public void remove(int key) {
			keys[key] = 0;
		}
	}
	
}
