import java.util.*;

public class SuperArray{
    public static String[] arr;

    public SuperArray(){
	arr = new String[10];
    }

    public SuperArray(int len){
	arr = new String[len];
    }

    public static char compare(String a, String b, int charPlace){
	char aChar = a.charAt(charPlace);
	char bChar = b.charAt(charPlace);
	if (aChar < bChar){
	    return aChar;
	} else if (bChar < aChar){
	    return bChar;
	} else {
	    return '.';
	}
    }

    public static void sort(){
	for (int i = 0; i < arr.length; i++){
	    String tester = arr[i];
	    for (int x = 0; x < arr.length-1; x++){
		String current = arr[x];
		int charPlace = 0;
		char compareAns = compare(tester,current,charPlace);		
		if (compareAns == current.charAt(charPlace)){
		    remove(i);
		    add(tester,x);
		    System.out.println("compareAns == " + current);
		    break;
		} else if (compareAns == tester.charAt(charPlace)){
		    System.out.println("compareAns == " + tester);
		} else {
		    System.out.println("else");
		    while (compareAns == '.' && charPlace < tester.length() & charPlace < current.length()){
			compareAns = compare(tester,current,charPlace);
			charPlace++;
		    }
		}
	    }
	}
    }

    public String toString(){
	String ans = "[ ";
	for (int i = 0; i < arr.length; i++){
	    if (arr[i] != null){
	    ans += arr[i];
	    ans += " ";
	    }
	}
	ans += "]";
	return ans;
    }

    public void resize(int newSize){
	String[] newArr = new String[newSize];
	String[] less;
	String[] more;
	if (arr.length > newArr.length){
	    more = arr;
	    less = newArr;
	} else {
	    more = newArr;
	    less = arr;
	}
	for (int i = 0; i < less.length; i++){
	    newArr[i] = arr[i];
	}
	arr = newArr;
    }

    public static void add(String o){
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

    public static void add(String o, int index){
	String[] newArr;
	if (size() >= arr.length){
	    newArr = new String[arr.length*2];
	} else {
	    newArr = new String[arr.length];
	}
	try {
	    for (int x = 0; x < index; x++){
		newArr[x] = arr[x];
	    }
	    newArr[index] = o;
	    for (int y = index; y < size(); y++){
		newArr[y+1] = arr[y];
	    } 
	}
	catch (IndexOutOfBoundsException e) {
	    System.out.println("The index needs to be greater than or equal to zero and less than " + size() + ".");	
	    for (int i = 0; i < size(); i++){
		newArr[i] = arr[i];
	    }
	}
	arr = newArr;
    }

    public static int size(){
	int ans = 0;
	for (int i = 0; i < arr.length; i++){
	    if (arr[i] != null){
		ans++;
	    }
	}
	return ans;
    }

    public void clear(){
	for (int i = 0; i < arr.length; i++){
	    arr[i] = null;
	}
    }

    public void set(int index, String e){
	arr[index] = e;
    }

    public String get(int index){
        String ans;
        try {
	    if (index < size()){
		ans = arr[index];
	    } else {
		ans  = "The index needs to be greater than or equal to zero and less than " + size() + ".";	
	    }
	}
	catch (IndexOutOfBoundsException e){
	    ans  = "The index needs to be greater than or equal to zero and less than " + size() + ".";		
	}
	return ans;
    }

    public static String remove(int index){
	String ans;
	String[] newArr;
	if (size() <= arr.length/4){
	    newArr = new String[arr.length/2];
	} else {
	    newArr = new String[arr.length];
	}
	    try	{
		if (index < size()){
		    for (int i = 0; i < index; i++){
			newArr[i] = arr[i];
		    }
		    ans = arr[index];
		    for (int i = index; i < size(); i++){
			newArr[i] = arr[i+1];
		    }
		} else {
		    ans = "The index needs to be greater than or equal to zero and less than " + size() + ".";
		    for (int i = 0; i < arr.length; i++){
		    newArr[i] = arr[i];
		    }
		}
	    }
	    catch (IndexOutOfBoundsException e){
	        ans = "The index needs to be greater than or equal to zero and less than " + size() + ".";		
		for (int i = 0; i < arr.length; i++){
		    newArr[i] = arr[i];
		}
	    }
	arr = newArr;
	return ans;
    }

}
