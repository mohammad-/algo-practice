package ds;
public class LinkedList<Item> implements List<Item>{
	private Node first;
	private Node last;
	private int size = 0;
	public void add(Item i){
		//Create node with data		
		Node n = new Node();
		n.data = i;
		
		//when list has no data
		if(first == null){
			first = n;
			last = first;
		}//when list has data
		else{
			last.next = n;
			n.previous = last;
			last = n;
		}
		//increment the size
		size++;
	}
	
	public void add(int index, Item node){
		Node temp = getNode(index);
		Node newNode = new Node();
		
		newNode.next = temp;
		newNode.previous = temp.previous;
		temp.previous = newNode;
		if(index == 0) first = newNode;
	}
	
	private Node getNode(int index){
		if(index >= size || index < 0) throw new IndexOutOfBoundsException("Index Should Be Between 0 ~ "+size);
		if(index == 0) return first;
		if(index == size-1) return last;
		Node temp = first;
		for(int i=0;i<index;i++){
			temp = temp.next;
		}
		return temp;		
	}
		
	public Item get(int index){
		Node n = getNode(index);
		return n.data;
	}
	
	public void swap(int i, int j){
		if(i == j) return;
		
 		Node node_i = getNode(i);
 		Node node_j = getNode(j);
 		Item temp = node_i.data;
 		node_i.data = node_j.data;
 		node_j.data = temp;
	}
	
	public void remove(int index){
		if(index == 0){
			Node temp = first;
			first = first.next;
			first.previous = null;
			temp.next = null;
		}
		else if(index == size-1){
			Node temp = last;
			last = last.previous;
			temp.previous = null;
			last.next = null;
		}		
		else{
			Node temp = getNode(index);
			temp.previous.next = temp.next;	
			temp.next.previous = temp.previous;
			temp = null;
		}		
		size--;
	}
		
	public int size(){
		return size;
	}
	
	private class Node{
		Item data;
		Node next;
		Node previous;		
	}
}