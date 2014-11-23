import java.util.*;

public class WordSearchTester {

    public static void main(String[]args){
	WordSearch.doIt();

	Random r = new Random();

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

	WordSearch example = new WordSearch(20,20);

	System.out.println(example.toString());
	
	for (int i = 0; i < wordBank.length; i++){
	    int what = r.nextInt(3);
	    switch (what){
	    case 0:
		example.addWordHorizontal(wordBank[i], r.nextInt(20), r.nextInt(20));
		    break;
	    case 1:
		example.addWordVertical(wordBank[i], r.nextInt(20), r.nextInt(20));
		break;
	    case 2: 
		example.addWordDiagonal(wordBank[i], r.nextInt(20), r.nextInt(20));
		break;
	    }
;
	}
	//	example.addWordHorizontal("hello",0,0);
	System.out.println(example.toString());
	
    }

}
