
public class SortMain{

	public static void main(String[] args){
		System.out.println("Sorting Demo " + args.length);
		int[] input = new int[args.length];
		for(int index = 0; index < args.length; index++){
			input[index] = Integer.parseInt(args[index]);
		}

		SelectionSort.sort(input);

	}
}