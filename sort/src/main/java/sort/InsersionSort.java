package sort;
import ds.*;

public class InsersionSort{
	public static <Item> void sort(List<Item> data, Comparator<Item> comparator){
		for(int i = 0; i < data.size(); i++){
			for(int j = i; j-1 >= 0; j--){
				if(comparator.compare(data.get(j-1), data.get(j)) > 0){
					data.swap(j, j-1);
				}else{
					break;
				}
			}
		}
	}
}