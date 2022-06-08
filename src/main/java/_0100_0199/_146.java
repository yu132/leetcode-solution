package _0100_0199;

import java.util.HashMap;
import java.util.Map;

public class _146 {
	
	class LRUCache {
		
		class TwoWayLinkedNode{
			TwoWayLinkedNode before;
			TwoWayLinkedNode next;

			int key;
			int value;
		}
		
		private void moveToHead(TwoWayLinkedNode node){
			node.before.next=node.next;
	    	node.next.before=node.before;
	    	
	    	head.next.before=node;
	    	node.next=head.next;
	    	
	    	head.next=node;
	    	node.before=head;
		}
		
		private TwoWayLinkedNode head;
		
		private TwoWayLinkedNode tail;
		
		private Map<Integer,TwoWayLinkedNode> map=new HashMap<>();
		
		int capacity;

	    public LRUCache(int capacity) {
	    	head=new TwoWayLinkedNode();
	    	tail=new TwoWayLinkedNode();
	    	
	    	head.next=tail;
	    	tail.before=head;
	    	
	        this.capacity=capacity;
	    }
	    
	    public int get(int key) {
	    	TwoWayLinkedNode node=map.get(key);
	    	
	    	if(node==null)
	    		return -1;
	    	
	    	moveToHead(node);
	    	
	    	return node.value;
	    }
	    
	    public void put(int key, int value) {
	    	TwoWayLinkedNode nodeExist=map.get(key);
	    	
	    	if(nodeExist!=null){
	    		
	    		nodeExist.value=value;
	    		
	    		moveToHead(nodeExist);
	    		
	    		return;
	    	}
	    	
	        if(capacity==map.size()){
	        	TwoWayLinkedNode giveUpNode=tail.before;
	        	
	        	map.remove(giveUpNode.key);
	        	
	        	giveUpNode.key=key;
	        	giveUpNode.value=value;
	        	
	        	moveToHead(giveUpNode);
	        	
	        	map.put(key, giveUpNode);
	        }else{
	        	TwoWayLinkedNode node=new TwoWayLinkedNode();
	        	
	        	node.key=key;
	        	node.value=value;
	        	
	        	head.next.before=node;
	        	node.next=head.next;
	        	
	        	node.before=head;
	        	head.next=node;
	        	
	        	map.put(key, node);
	        }
	    }
	}
	
}
