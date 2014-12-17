import java.util.*;

public class BubbleSort {

    public static void bubbleSort(int[] arr){	
	int swaps = 1;
	while (swaps > 0){
	    swaps = 0;
	    for (int x = 0; x < arr.length-1; x++){
		if (arr[x] > arr[x+1]){
		    swaps++;
		    int hold = arr[x+1];
		    arr[x+1] = arr[x];
		    arr[x] = hold;
		    swaps++;
		}
	    }
	}
    }

 public static void main(String[]args){
	int[] a = new int[20];
	Random r = new Random();

	for (int i = 0; i < 20; i++){
	    a[i] = r.nextInt(100);
	}



	System.out.println(Arrays.toString(a));
	bubbleSort(a);
	System.out.println(Arrays.toString(a));
    }


}
