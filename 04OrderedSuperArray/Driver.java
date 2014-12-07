import java.util.*;

public class Driver{

    public static void main(String[]args){
	Random r = new Random();
	SuperArray arr = new SuperArray();
	
	for(int i = 0; i < 100000 ; i++){
	    char c = (char)(r.nextInt(26) + 'a');
	    String s = new Character(c).toString();
	    arr.add(s);
	}
	
	System.out.println(arr.toString());
	arr.sort();
	System.out.println(arr.toString());
    }
}
