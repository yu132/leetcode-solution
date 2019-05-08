package _0_99;

import java.util.ArrayList;

import model.ListNode;

public class _23 {

	public static class CompleteWinnerTree<W extends Comparable<W>> {
		
		private Object[] weights;
		private int[] completeTree;
		private int level;

		public CompleteWinnerTree(W[] weights){
			if(weights.length<2)
				throw new IllegalArgumentException("weights's number can't be small than 2");
			level=(int)Math.ceil(Math.log(weights.length)/Math.log(2));
			this.weights=new Object[(int)Math.pow(2, level)+1];
			for(int i=0;i<weights.length;i++)
				this.weights[i+1]=weights[i];
			completeTree=new int[(int)Math.pow(2, level)];
			init();
		}
		
		@SuppressWarnings("unchecked")
		private void init(){
			for(int i=(int)Math.pow(2, level-1),j=1;i<(int)Math.pow(2, level);i++,j+=2)
				completeTree[i]=compareW(((W)weights[j]),(W)weights[j+1])>=0?j:j+1;
			for(int i=level-2;i>=0;i--){
				for(int j=(int)Math.pow(2, i);j<(int)Math.pow(2, i+1);j++)
					completeTree[j]=compareW((W)weights[completeTree[j*2]],(W)weights[completeTree[j*2+1]])>=0?completeTree[j*2]:completeTree[j*2+1];
			}
		}
		
		@SuppressWarnings("unchecked")
		private int compareW(Object o1,Object o2){
			if(o1==null){
				if(o2==null)
					return 0;
				else
					return -1;
			}else{
				if(o2==null)
					return 1;
				else
					return ((W)o2).compareTo((W)o1);
			}
		}
		
		@SuppressWarnings("unchecked")
		public void reComplete(int location,W weight){
			weights[location]=weight;
			int n=(int)Math.pow(2, level-1)+(location+1)/2-1;
			if(location%2==0)
				completeTree[n]=compareW((W)weights[location-1],(W)weights[location])>=0?location-1:location;
			else 
				completeTree[n]=compareW((W)weights[location],(W)weights[location+1])>=0?location:location+1;
			do{
				n/=2;
				completeTree[n]=compareW((W)weights[completeTree[n*2]],(W)weights[completeTree[n*2+1]])>=0?completeTree[n*2]:completeTree[n*2+1];
			}while(n!=1);
		}
		
		public int getCompleteTreeElement(int index){
			if(index<1||index>=completeTree.length)
				throw new IndexOutOfBoundsException();
			else
				return completeTree[index];
		}

		public void print(){
			for(int i=1;i<weights.length;i++)
				System.out.print(weights[i]+" ");
			System.out.println();
			for(int i=1;i<completeTree.length;i++)
				System.out.print(completeTree[i]+" ");
			System.out.println();
		}
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode head=new ListNode(0);
		
		ListNode temp=head;
		
		while(l1!=null&&l2!=null){
			if(l1.val==l2.val){
				temp.next=l1;
				temp=temp.next;
				l1=l1.next;
				
				temp.next=l2;
				temp=temp.next;
				l2=l2.next;
			}else if(l1.val>l2.val){
				temp.next=l2;
				temp=temp.next;
				l2=l2.next;
			}else{
				temp.next=l1;
				temp=temp.next;
				l1=l1.next;
			}
		}
		
		if(l1!=null)
			temp.next=l1;
		if(l2!=null)
			temp.next=l2;
		
		return head.next;
    }
	
	public ListNode mergeKLists(ListNode[] lists) {
		
		ArrayList<ListNode> l=new ArrayList<>();
		
		for(int i=0;i<lists.length;i++){
			if(lists[i]!=null)
				l.add(lists[i]);
		}
		
		lists=l.toArray(new ListNode[l.size()]);
		
		if(lists.length==0)
			return null;
		if(lists.length==1)
			return lists[0];
		if(lists.length==2)
			return mergeTwoLists(lists[0],lists[1]);
		
		ListNode head=new ListNode(0);
		ListNode temp=head;
		
		Integer[] ele=new Integer[lists.length];
		
		for(int i=0;i<lists.length;i++){
			ele[i]=lists[i]==null?null:lists[i].val;
		}
		
		CompleteWinnerTree<Integer> cwt=new CompleteWinnerTree<>(ele);
		cwt.init();
		
		while(true){
			int index=cwt.getCompleteTreeElement(1)-1;
			
			System.out.println(index);
			
			if(index>=lists.length||lists[index]==null)
				break;
			
			temp.next=lists[index];
			temp=temp.next;
			
			lists[index]=lists[index].next;
			
			cwt.reComplete(index+1, lists[index]==null?null:lists[index].val);
		}
		
		return head.next;
	}
	
	public static void main(String[] args) {
		ListNode[] lists=new ListNode[3];
		lists[0]=new ListNode(1);
		ListNode t1=new ListNode(2);
		ListNode t2=new ListNode(3);
		lists[0].next=t1;
		t1.next=t2;
		
		
		lists[1]=new ListNode(2);
		
		lists[2]=new ListNode(2);
		System.out.println(new _23().mergeKLists(lists));
	}
	
	
	
}
