package ds;
//return positive if a > b
//return negative if a < b
//return 0 if a.equals(b)
public interface Comparator<Item>{
	public int compare(Item a, Item b);
}