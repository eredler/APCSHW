public class OrderedSuperArray extends SuperArray{
    String[] arr;

    public OrderedSuperArray(){
	arr = new String[10];
    }

    public OrderedSuperArray(int len){
	arr = new String[len];
    }

    public static void order(){
	for (int i = 1; i < arr.length; i++){
	    String first = arr[i-1];
	    String second = arr[i];
	    //  if 
	}
    }

    public void add(String o){
	String[] newArr;
	if (size() >= arr.length){
	    newArr = new String[arr.length*2];
	} else {
	    newArr = new String[arr.length];
	}
	for (int i = 0; i < arr.length; i++){
	    newArr[i] = arr[i];
	}
	newArr[size()] = o;
	arr = newArr;
    }

    public void add(String o, int index){
	String[]newArr = new String[arr.length+1];
	try{
	    add(o);
	} catch (IndexOutOfBoundsException e) {
	    System.out.println("The index needs to be greater than or equal to zero and less than " + size() + ".");	
	    for (int i = 0; i < size(); i++){
		newArr[i] = arr[i];
	    }
	}
	arr = newArr;
    }

    public void set(int index, String e){
	arr[index] = e;
    }

}
