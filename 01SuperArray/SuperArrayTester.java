public class SuperArrayTester{

    public static void main(String[]args){
	
	SuperArray a = new SuperArray();
	SuperArray b = new SuperArray(5);
	System.out.println(a.toString());
	System.out.println(b.toString());
	a.add("Hello");
	System.out.println(a.toString());
	b.resize(2);
	System.out.println(b.toString());
	System.out.println(a.size());
	a.clear();
	System.out.println(a.toString());
	b.set(0, "yoyo");
	System.out.println(b.toString());
	System.out.println(b.get(0));
	System.out.println(b.get(1));
	b.add("hi");
	System.out.println(b.toString());
	b.add("yellow");
	System.out.println(b.toString());
	b.add("red",1);
	System.out.println(b.toString());
	b.remove(4);
	System.out.println(b.toString());
	System.out.println(b.remove(1));
	System.out.println(b.toString());

    }

}
