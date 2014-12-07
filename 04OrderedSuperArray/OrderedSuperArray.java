public class OrderedSuperArray extends SuperArray{
    SuperArray arr;

    public OrderedSuperArray(){
	arr = new SuperArray(10);
    }

    public OrderedSuperArray(int len){
	arr = new SuperArray(len);
    }

    public void add(String o){
	super.add(o);
	sort();
    }

    public void add(String o, int index){
	super.add(o);
	sort();
    }

    public String set(int index, String e){
	super.add(e);
	sort();
	return e;
    }

    public static boolean checkIfFirst(int pos, String target, SuperArray a){
	int i = pos-1;
	boolean ans = false;
	while (i > 0){
	    if (a.get(pos).equals(target)){
		i--;
	    } else {
		ans = true;
		i = 0;
	    }
	}
	return ans;
    }

    public static int find(String target, SuperArray a){
	int first = 0;
	int last = a.getNumEl()-1;
	int middle = (first + last) / 2;
	while (first < last){
	    if (a.get(middle).equals(target)){
		while (checkIfFirst(middle,target,a) == false){
		    middle--;
		}
		return middle+1;
	    } else if (a.get(middle).compareTo(target) > 0){
		last = middle; 
		middle = (first + last) / 2;
	    } else {
		first = middle;
		middle = (first + last) / 2;
	    }
	}
	return -1;
    }

}
