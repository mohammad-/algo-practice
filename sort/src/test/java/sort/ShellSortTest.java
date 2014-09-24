package sort;
import junit.framework.*;
import static org.junit.Assert.*;	
import ds.List;
import ds.Comparator;
import ds.ArrayList;

public class ShellSortTest extends TestCase{
	private List<String> list;

	private static final Comparator<String> c = new Comparator<String>(){
	
		@Override
		public int compare(String a, String b){
			return a.compareTo(b);
		}
	};

	public void setUp(){
		list = new ArrayList<String>();
	}	
	
	public void tearDown(){
		list = null;
	}
	
	public void test_easy_sort(){
		add_10_items();
		ShellSort.sort(list,c);

		for(int i=0;i+1<list.size();i++){
			assertTrue(c.compare(list.get(i),list.get(i+1)) < 0);
		}
	}

	public void test_second_sort(){
		add_11_items();
		ShellSort.sort(list,c);

		for(int i=0;i+1<list.size();i++){
			assertTrue(c.compare(list.get(i),list.get(i+1)) < 0);
		}
	}

	public void test_third_sort(){
		add_100_items();
		ShellSort.sort(list,c);

		for(int i=0;i+1<list.size();i++){
			assertTrue(c.compare(list.get(i),list.get(i+1)) < 0);
		}
	}

	private void add_10_items(){
		list.add("Z");
		list.add("X");
		list.add("P");				
		list.add("Q");		
		list.add("M");				
		list.add("N");				
		list.add("C");						
		list.add("V");				
		list.add("B");				
		list.add("A");				


	}

	private void add_11_items(){
		list.add("zero");
		list.add("one");
		list.add("two");		
		list.add("three");				
		list.add("four");				
		list.add("five");				
		list.add("six");				
		list.add("seven");				
		list.add("eight");				
		list.add("nine");				
		list.add("ten");						

	}
	
	private void add_100_items(){
		for(int i=0;i<100;i++){
			list.add(i+"");
		}
	}

}