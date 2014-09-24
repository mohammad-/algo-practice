package ds;

public class ArrayList<Item> implements List<Item>{
	private Item[] data;
	private int size;
	
	public ArrayList(){
		data = (Item[])new Object[8];
		size = 0;
	}
	
	public void add(Item item){
		if(size == data.length){
			expandArray();
		}		
		data[size] = item;	
		size++;
	}
	
	public void add(int index, Item node){
		if(index > size && index <=0){		
			throw new IndexOutOfBoundsException(
				"Index Out Of Bound");
		}

		if(size == data.length){
			expandArray();
		}
		int tempSize = size;		
		while(tempSize > index){
			data[tempSize] = data[tempSize-1];
			tempSize--;
		}		
		data[index] = node;
		size++;
	}
	
	public Item get(int index){
		if(index < size && index >=0){		
			return data[index];
		}else{
			throw new IndexOutOfBoundsException(
				"Index Out Of Bound");
		}
	}
	
	public void remove(int index){	
		if(index < size && index >=0){
			if(data.length/4 == (size-1) ){
				shrinkArray();
			}			
			int tempIndex = index;
			while(tempIndex+1 < size){
				data[tempIndex] = data[tempIndex+1];
				tempIndex++;
			}
			size--;
		}else{
			throw new IndexOutOfBoundsException(
				"Index Out Of Bound. " );
		}	
	}
	
	public void swap(int i, int j){
		Item at_i = data[i];
		data[i] = data[j];
		data[j] = at_i;
	}
	
	public int size(){
		return size;
	}

	private void expandArray(){
	 	Item[] temp = (Item[])new Object[data.length * 2];
 		System.arraycopy(data,0,temp, 0,data.length);
 		data = temp;
	}
	
	private void shrinkArray(){
		if(data.length/2 > 8){
		 	Item[] temp = (Item[])new Object[data.length / 2];
 			System.arraycopy(data,0,temp, 0,size);
	 		data = temp;	
		}
	}
	
}