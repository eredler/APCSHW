import java.util.*;

public class WordSearchTester {

    public static void main(String[]args){
	//	ArrayList<String> temp = WordSearch.doIt();
	int numrows = 20;
	int numcols = 20;

	Random r = new Random();

	//	String[] wordBank = WordSearch.doIt();
	String[] wordBank = new String[10];
	wordBank[0] = "abhor";
	wordBank[1] = "bigot";
	wordBank[2] = "counterfeit";
	wordBank[3] = "enfranchise";
	wordBank[4] = "hamper";
	wordBank[5] = "kindle";
	wordBank[6] = "noxious";
	wordBank[7] = "placid";
	wordBank[8] = "renumeration";
	wordBank[9] = "talisman";

	WordSearch example = new WordSearch(numrows,numcols);

	//	System.out.println(example.toString());
	for (int i = 0; i < wordBank.length; i++){
	    boolean success = false;
	    int trynum = 0;
	    while (trynum < 50){
		//	int what = r.nextInt(3);
		int what = 0;
		switch (what){
		case 0:
		    if (success == false){
			success = example.addWordHorizontal(wordBank[i], r.nextInt(numrows), r.nextInt(numcols));
			trynum++;
		    } else {
		        trynum = 50;
		    }
		    break;
		case 1:
		    example.addWordVertical(wordBank[i], r.nextInt(numrows), r.nextInt(numcols));
		    break;
		case 2: 
		    example.addWordDiagonal(wordBank[i], r.nextInt(numrows), r.nextInt(numcols));
		    break;
		}
	   		
		//	System.out.println("word: " + wordBank[i]);
		//	System.out.println("trynum = " + trynum);
		//	System.out.println("Success: " + success);
	    }
	}
	//	example.addWordHorizontal("hello",0,0);
	System.out.println(example.toString());
	
    }

}
