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

    public void add(Object e){
	Object[] newArr = new Object[arr.length+1];
	for (int i = 0; i < arr.length; i++){
	    newArr[i] = arr[i];
	}
	newArr[arr.length] = e;
	arr = newArr;
    }

    public void add(Object e, int index){
	Object[] newArr = new Object[arr.length+1];
	for (int x = 0; x < index; x++){
	    newArr[x] = arr[x];
	    }
	newArr[index] = e;
	for (int y = index; y < arr.length; y++){
	    newArr[y+1] = arr[y];
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
	    ans = arr[index];
	}
	catch (IndexOutOfBoundsException e){
	    ans  = "The index needs to be greater than or equal to zero and less than " + size() + ".";		
	}
	return ans;
    }

    public Object remove(int index){
	Object[] newArr = new Object[arr.length];
	Object ans;
	    try	{
		for (int i = 0; i < index; i++){
		    newArr[i] = arr[i];
		}
		ans = arr[index];
		for (int i = index; i < size(); i++){
		    newArr[i] = arr[i+1];
		}
	    }
	    catch (IndexOutOfBoundsException e){
		System.out.println("The index needs to be greater than or equal to zero and less than " + size() + ".");
		ans = null;		
		for (int i = 0; i < arr.length; i++){
		    newArr[i] = arr[i];
		}
	    }
	arr = newArr;
	return ans;
    }

}
