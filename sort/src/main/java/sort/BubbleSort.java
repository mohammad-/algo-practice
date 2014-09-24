package sort;
import ds.*;

public class BubbleSort{
	public static <Item> void sort(List<Item> data, Comparator<Item> comparator){
		int length = data.size();
		for(int i = length; i >= 0; i--){
			for(int j=0; j+1<i; j++){
				if(comparator.compare(data.get(j), data.get(j+1)) > 0){
					data.swap(j,j+1);
				}
			}			
		}
	}
}