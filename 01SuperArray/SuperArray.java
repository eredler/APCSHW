public class SuperArray{
    Object[] arr;

    public SuperArray(){
	arr = new Object[10];
    }

    public SuperArray(int len){
	arr = new Object[len];
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
	Object[] newArr = new Object[newSize];
	Object[] less;
	Object[] more;
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

    public void add(Object o){
	Object[] newArr;
	if (size() >= arr.length){
	    newArr = new Object[arr.length*2];
	} else {
	    newArr = new Object[arr.length];
	}
	for (int i = 0; i < arr.length; i++){
	    newArr[i] = arr[i];
	}
	newArr[size()] = o;
	arr = newArr;
    }

    public void add(Object o, int index){
	Object[] newArr;
	if (size() >= arr.length){
	    newArr = new Object[arr.length*2];
	} else {
	    newArr = new Object[arr.length];
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

    public int size(){
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

    public void set(int index, Object e){
	arr[index] = e;
    }

    public Object get(int index){
        Object ans;
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

    public Object remove(int index){
	Object ans;
	Object[] newArr;
	if (size() <= arr.length/4){
	    newArr = new Object[arr.length/2];
	} else {
	    newArr = new Object[arr.length];
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
