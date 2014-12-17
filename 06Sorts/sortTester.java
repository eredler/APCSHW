import java.util.*;

public class sortTester {

    public static void main(String[]args){
	int[] a = new int[20];
	Random r = new Random();

	for (int i = 0; i < 20; i++){
	    a[i] = r.nextInt(100);
	}

	System.out.println(a.toString());
	BubbleSort.bubbleSort(a.toString());
	System.out.println(a.toString());
    }

}
