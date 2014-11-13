import java.util.ArrayList;

public class collapse {

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
    }

}
