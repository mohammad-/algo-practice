package sort;

import ds.List;
import ds.Comparator;

public class SelectionSort{
	public static <Item> void sort(List<Item> data, Comparator<Item> comparator){
		int length = data.size();
		for(int i = 0; i < length; i++){
			int minIndex = i;
			for(int j=i+1; j<length; j++){
				if(comparator.compare(data.get(minIndex), data.get(j)) > 0){
					minIndex = j;
				}
			}			
			if(minIndex!=i){
				data.swap(i,minIndex);
			}
		}
	}
}
