import java.util.*;

public class Driver{

    public static void main(String[]args){
	long start, end;
	Random r = new Random();
	int [] b = new int[100000];
	int [] i = new int[100000];
	int [] s = new int[100000];
	int [] c = new int[100000];
	int [] rx = new int[100000];
	int a;
	for (int x = 0; x < 100000; x++){
	    a = r.nextInt(1000);
	    b[x] = a;
	    i[x] = a;
	    s[x] = a;
	    c[x] = a;
	    rx[x] = a;
	}
	
	start = System.currentTimeMillis();
	Sorts.bubble(b);
	end = System.currentTimeMillis();
	System.out.println("bubble: ");
	System.out.println(end - start);

	start = System.currentTimeMillis();
	Sorts.insertion(i);
	end = System.currentTimeMillis();
	System.out.println("insertion: ");
	System.out.println(end - start);
	
	start = System.currentTimeMillis();
	Sorts.selection(s);
	end = System.currentTimeMillis();
	System.out.println("selection: ");
	System.out.println(end - start);
	
	start = System.currentTimeMillis();
	Arrays.sort(c);
	end = System.currentTimeMillis();
	System.out.println("arrays.sort: ");
	System.out.println(end - start);
	
	
	start = System.currentTimeMillis();
	Sorts.radix(rx);
	end = System.currentTimeMillis();
	System.out.println("radix: ");
	System.out.println(end - start);
    }
}
