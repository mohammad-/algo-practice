package ds;
public interface List<Item>{
	public void add(Item node);
	public void add(int index, Item node);
	public Item get(int index);
	public void remove(int index);	
	public void swap(int i, int j);
	public int size();	
}