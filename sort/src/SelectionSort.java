public class SelectionSort{
	public static void sort(int[] data){
		int length = data.length;
		for(int i = 0; i< length;i++){
			int min = i;
			for(int j=i+1; j<length; j++){
				if(data[j] < data[i])
					min = j;
			}
			if(min!=i){
				swap(data,i,min);
			}
			printStep(data);
		}
	}
	
	private static int less(int a, int b){
		if(a < b) return -1;
		else if(a > b) return +1;
		else return 0;
	}
	
	private static void swap(int[] data, int i, int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	private static void printStep(int[] input){
		for(int index = 0; index < input.length; index++){
			System.out.print(input[index]);
		}
		System.out.println("");
	}
}
