import java.util.*;

public class Sorts { 

    /////////////////////////////////////////////////////
    // misc

    public static String name(){
	return "Redler,Emily";
    }

    public static int period(){
	return 6;
    }

    /////////////////////////////////////////////////////
    // Sorts

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

    public static void radix(int[] arr){
	//	System.out.println(Arrays.toString(arr));
	ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
	fillArray(bucket,10);

	int passes = numDigits(arr[0]);
	for (int i = 1; i < arr.length; i++) {
	    passes = Math.max(passes, arr[i]);
	}

	for (int place = 0; place < passes; place++) {

	    for (int i = 0; i < arr.length; i++) {
		bucket.get(getDigit(arr[i], place + 1)).add(arr[i]);
	    }

	    int counter = 0;

	    for (int i = 0; i < bucket.size(); i++) {
		for (int c = 0; c < bucket.get(i).size(); c++) {
		    arr[counter] = bucket.get(i).get(c);
		    counter++;
		}
		bucket.get(i).clear();
	    }
	}
	//	System.out.println(Arrays.toString(arr));
    }

    ///////////////////////////////////////////////////////
    // Helpers

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

    public static void fillArray(ArrayList<ArrayList<Integer>> arr, int howMany){
	for (int i = 0; i < howMany; i++){
	    ArrayList<Integer> x = new ArrayList<Integer>();
	    arr.add(x);
	}
    }

    public static ArrayList<ArrayList<Integer>> copyArray(ArrayList<ArrayList<Integer>> arr){
	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	for (int i = 0; i < arr.size(); i++){
	    ans.add(arr.get(i));
	}
	return ans;
    }

    private static int numDigits(int x) {
	int digits = 0;
	for (; Math.abs(x) > 0; digits++) {
	    x = x / 10;
	}
	return digits;
    }

    public static int getDigit(int n, int place) {
	return Math.abs((n/(int)Math.pow(10,(double)place-1))%10);
    }

}
