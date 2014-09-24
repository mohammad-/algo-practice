package ds;

import junit.framework.*;
import static org.junit.Assert.*;

public class ArrayListTest extends TestCase{
	private ArrayList<String> list;	
	
	public void setUp(){
		list = new ArrayList<String>();
	}
	
	public void tearDown(){
		list = null;
	}
	
	public void test_that_list_can_be_created(){
		assertNotNull(list);
		assertTrue(list.size() == 0);
	}
	
	public void test_add_operation_first(){
		list.add("One");
		assertTrue(list.size() == 1);
	}
	
	public void test_add_operation_last(){
		list.add("One");
		list.add("Two");		
		list.add("Three");				
		assertTrue(list.size() == 3);
	}
	public void test_add_more_items(){
		add_10_items();
		assertTrue(list.size() == 10);
	}
	
	public void test_get_first(){
		add_10_items();
		assertNotNull(list.get(0));
		assertEquals(list.get(0),"One");
	}

	public void test_get_last(){
		add_10_items();
		assertNotNull(list.get(9));
		assertEquals(list.get(9),"Ten");
	}

	public void test_get_anything_else(){
		add_10_items();
		
		assertNotNull(list.get(5));
		assertEquals(list.get(5),"Six");
		
		assertNotNull(list.get(7));
		assertEquals(list.get(7),"Eight");
	}
	
	public void test_get_out_of_bound(){
		add_10_items();
		try{
			String s = list.get(10);
			fail("Must Throw Exceprion");		
		}catch(IndexOutOfBoundsException e){
			assertNotNull(e);
		}catch(Exception e){
			fail("Expected IndexOutOfBoundsExceprion but its a "+e.toString());
		}
	}
	
	public void test_remove_first(){
		add_10_items();
		assertTrue(list.size() == 10);		
		
		list.remove(0);
		
		assertTrue(list.size() == 9);
		assertNotNull(list.get(0));		
		assertEquals(list.get(0),"Two");	
		assertEquals(list.get(8),"Ten");			
		assertEquals(list.get(5),"Seven");					

		try{
			String s = list.get(10);
			fail("Must Throw Exceprion");		
		}catch(IndexOutOfBoundsException e){
			assertNotNull(e);
		}catch(Exception e){
			fail("Expected IndexOutOfBoundsExceprion but its a "+e.toString());
		}		
	}	

	public void test_remove_last(){
		add_10_items();
		assertTrue(list.size() == 10);		
		
		list.remove(9);
		
		assertTrue(list.size() == 9);
		assertNotNull(list.get(0));		
		assertEquals(list.get(0),"One");	
		assertEquals(list.get(8),"Nine");			
		assertEquals(list.get(5),"Six");					

		try{
			String s = list.get(10);
			fail("Must Throw Exceprion");		
		}catch(IndexOutOfBoundsException e){
			assertNotNull(e);
		}catch(Exception e){
			fail("Expected IndexOutOfBoundsExceprion but its a "+e.toString());
		}		
	}	

	public void test_remove_any(){
		add_10_items();
		assertTrue(list.size() == 10);		
		
		list.remove(4);
		
		assertTrue(list.size() == 9);
		assertNotNull(list.get(0));		
		assertEquals(list.get(0),"One");	
		assertEquals(list.get(4),"Six");			
		assertEquals(list.get(8),"Ten");					
		assertEquals(list.get(7),"Nine");					
		try{
			String s = list.get(10);
			fail("Must Throw Exceprion");		
		}catch(IndexOutOfBoundsException e){
			assertNotNull(e);
		}catch(Exception e){
			fail("Expected IndexOutOfBoundsExceprion but its a "+e.toString());
		}		
	}	

	public void test_swap(){
		add_10_items();
		list.swap(0,9);
		assertEquals(list.get(0),"Ten");			
		assertEquals(list.get(9),"One");
		
		list.swap(1,1);
		assertEquals(list.get(1),"Two");
		
		list.swap(2,5);
		assertEquals(list.get(2),"Six");
		assertEquals(list.get(5),"Three");		

	}	
	
	public void test_large_size(){
		add_100_items();
		for(int i = 99;i>=0;i--){
			list.remove(i);
			assertTrue(list.size() == i);
			if(i>0)
				assertEquals(list.get(i-1),(i-1)+"");
		}
	}
	
	public void test_large_size_add(){
		for(int i=0;i<10;i++){
			list.add(0,i+"");
			assertTrue(list.size() == (i+1));
			assertEquals(list.get(0),(i)+"");
		}

		for(int i=10;i<20;i++){
			list.add(5,i+"");
			assertTrue(list.size() == (i+1));
			assertEquals(list.get(5),i+"");
		}
				
	}

	public void test_add_bigger_index(){
		add_10_items();
		try{
			list.add(100,"100");
			fail();
		}catch(IndexOutOfBoundsException e){
			assertTrue(list.size() == 10);
		}
				
	}

	private void add_10_items(){
		list.add("One");
		list.add("Two");		
		list.add("Three");				
		list.add("Four");				
		list.add("Five");				
		list.add("Six");				
		list.add("Seven");				
		list.add("Eight");				
		list.add("Nine");				
		list.add("Ten");						

	}
	
	private void add_100_items(){
		for(int i=0;i<100;i++){
			list.add(i+"");
		}
	}

}