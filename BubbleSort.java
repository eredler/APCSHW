public class BubbleSort {

    public int[] arr;

    public void bubbleSort(){
	for (int i = 0; i < arr.length; i++){
	    for (int x = i; x < arr.length-1; x++){
		if (arr[x] > arr[x+1]){
		    int hold = arr[x+1];
		    arr[x+1] = arr[x];
		    arr[x] = hold;
		}
	    }
	}
    }

    public static void main(String[]args){
	
	

    }



}