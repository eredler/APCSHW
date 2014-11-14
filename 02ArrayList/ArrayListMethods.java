import java.util.*;

public class ArrayListMethods {

    public static void collapseDuplicates(ArrayList<Integer> L){
	for (int i = 1; i < L.size(); i++){
	    if (L.get(i-1).equals(L.get(i))){
		L.remove(i);
		i--;
	    }
	}	
    }

    public static Integer makeInt(int i){
	Integer ans = new Integer(i);
	return ans;
    }

    public static void randomize(ArrayList<Integer> L){
	for (int i = L.size(); i > 0; i--){
	    Random r = new Random();
	    int x = r.nextInt(i);
	    L.add(makeInt(L.get(x)));
	    L.remove(L.get(x));
	}
    }

    public static ArrayList<Integer> makeArrayListOfConsec(int length){
	ArrayList<Integer> ans = new ArrayList<Integer>();	    
	for (int i = 0; i < length; i++){
	    ans.add(makeInt(i));
	}
	return ans;
    }

    public static void main(String[]args){

	ArrayList<Integer> L = new ArrayList<Integer>();
	L.add(makeInt(1));
	L.add(makeInt(9));
	L.add(makeInt(3));
	L.add(makeInt(3));
	L.add(makeInt(4));
	L.add(makeInt(2));
	L.add(makeInt(2));
	L.add(makeInt(2));
	L.add(makeInt(7));
	L.add(makeInt(8));
	L.add(makeInt(8));
	L.add(makeInt(8));
	L.add(makeInt(8));
	L.add(makeInt(9));
	System.out.println(L);
	collapseDuplicates(L);
	System.out.println(L);
	ArrayList<Integer> example = new ArrayList<Integer>();
	example = makeArrayListOfConsec(20);
	System.out.println(example);
	randomize(example);
	System.out.println(example);
    }

}
