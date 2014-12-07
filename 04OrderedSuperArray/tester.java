import java.util.*;

public class tester{

    public static void main(String[]args){
       
	SuperArray x = new SuperArray(10);
	OrderedSuperArray y = new OrderedSuperArray(10);
	x.add("zebra");
	x.add("apricot");
	x.add("string");
	x.add("emily");
	x.add("emily");
	x.add("computer");
	x.add("apple");
       	x.add("emily");
	x.add("a");
	x.find("apple",x);
//	x.badInsertionSort(); // went past 60s
	y.add("water"); // my sort takes 0.132s
	y.add("emily");
	y.add("emily");
	y.add("emily");
	y.add("emily");
	y.add("zebra");
	y.add("apricot");
	y.add("string");
	y.add("computer");
	y.add("apple");
	y.add("a");
	y.add("water");
	//	System.out.println(y.toString());
	System.out.println(x.toString());
	/*	System.out.print("find first instance of 'string': ");
	System.out.println(y.find("string",y));
	System.out.print("find first instance of 'emily': ");
	System.out.println(y.find("emily",y));
	System.out.print("find first instance of 'string': ");*/
	System.out.print("find first instance of 'string': ");
	System.out.println(x.find("string",x));
	System.out.print("find first instance of 'emily': ");
	System.out.println(x.find("emily",x));
    }

}
