public class OrderedSuperArray extends SuperArray{
    String[] arr;

    public OrderedSuperArray(){
	arr = new String[10];
    }

    public OrderedSuperArray(int len){
	arr = new String[len];
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

   

}
