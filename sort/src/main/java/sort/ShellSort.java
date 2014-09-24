package sort;
import ds.List;
import ds.Comparator;

public class ShellSort{
	public static <Item> void sort(List<Item> data, Comparator<Item> comparator){
		int length = data.size();
		int h = 1;
        while (h < length/3) h = 3*h + 1; 
		while(h >= 1){			
			for(int i=h;i<length;i++){
				for(int j=i;(j-h)>=0;j-=h){
					if(comparator.compare(data.get(j),data.get(j-h)) < 0){						
						data.swap(j,j-h);
					}
				}
			}
			h = h/3;
		}
	}
}