public class SuperArray{
    public String[] arr;
    public int numEl;
    

    public SuperArray(){
	arr = new String[10];
    }

    public SuperArray(int len){
	arr = new String[len];
	numEl = 0;
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
	int i = 0;
	while (i < arr.length && i < newSize){
	    newArr[i] = arr[i];
	    i++;
	}
	arr = newArr;
    }
    
    public void add(String o){
	if (size() == arr.length){
	    resize(arr.length*2);
	    add(o);
	} else {
	    arr[size()] = o;
	    numEl++;
	}  
    }

    public void add(String o, int index){   
	String ans[] = new String[arr.length];
	if (size() == arr.length){
	    resize(arr.length * 2);
	    add(o,index);
	} else {
	    try {
		for (int i = 0; i < index; i++){
		    ans[i] = arr[i];
		}
		ans[index] = o;
		for (int i = index; i < size(); i++){
		    ans[i+1] = arr[i];
		}
	    } catch (IndexOutOfBoundsException e) {
		throw new IndexOutOfBoundsException();
	    }
	    arr = ans;
	    numEl++;
	}
    }

  public void sort(){
	if (size() == arr.length){
            resize(arr.length*2);
        }
	for (int i = 0; i < size(); i++){
	    String s = get(i);
	    int pos = i;
	    while (pos > 0 && get(pos-1).compareTo(s) > 0){
		arr[pos] = arr[pos-1];
		pos--;
	    }
	    arr[pos] = s;
	}
    }
   
    public int size(){
	return numEl;
    }

    public void clear(){
	for (int i = 0; i < arr.length; i++){
	    arr[i] = null;
	}
	numEl = 0;
    }

    public String set(int index, String s){
	try {	    
	    String x = arr[index];
	    arr[index] = s;
	    return x;
	} catch (IndexOutOfBoundsException e){
	    throw new IndexOutOfBoundsException();
	}
	
    }

    public String get(int index){
	try {
	    String ans = arr[index];
	    return ans;
	}
	catch (IndexOutOfBoundsException e){
	    throw new IndexOutOfBoundsException();
	}
    }

    public String remove(int index){
	String ans;
	if (size() <= arr.length/4){
	    resize(arr.length/2);
	}
	try {	    
	    ans = arr[index];
	    for (int i = index; i < size()-1 ; i++){
		arr[i] = arr[i+1];
	    }
	} catch (IndexOutOfBoundsException e) {
	    throw new IndexOutOfBoundsException();
	}
	return ans;
    }

}
