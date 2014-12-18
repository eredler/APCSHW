public class Sorts { 

    public static void selection(int[] arr){
	int x = 0;
	int hold = 0;
	for (int i = 0; i < arr.length; i ++){
	    x = minIndex(arr, i);
	    hold = arr[i];
	    arr[i] = arr[x];
	    arr[x] = hold;
	}
    }
    
    public static int minIndex(int[] arr, int start){
	int min = arr[start];
	int i = start;
	for (int x = start; x < arr.length; x++){
	    if (arr[x] < min){
		min = arr[x];
		i = x;
	    }
	}
        return i;
    }

    public static void insertion(int[] arr){
	for (int i = 0; i < arr.length; i++){
	    int s = arr[i];
	    int pos = i;
	    while (pos > 0 && arr[pos-1] < s){
		arr[pos] = arr[pos-1];
		pos--;
	    }
	    arr[pos] = s;
	}
    }
 

    public static void bubble(int[] arr){	
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

}
