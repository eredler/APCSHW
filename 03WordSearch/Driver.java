import java.util.*;

public class Driver {

    public static void addWordInDriver(WordSearch example, int numrows, int numcols, Random r, ArrayList<String> wordsUsed, String[] wordBank, int effort, int howManyWords){
	for (int i = 0; i < wordBank.length; i++){
	    boolean success = false;
	    int trynum = 0;
	    int spot = r.nextInt(wordBank.length);
	    if (wordsUsed.contains(wordBank[spot])){
		trynum = effort;
	    }
	    if (wordsUsed.size() > howManyWords){
		trynum = effort;
		i = wordBank.length;
	    }
	    while (trynum < effort){
		int dx = r.nextInt(3) - 1;
		int dy = r.nextInt(3) - 1;
		int rw = r.nextInt(numrows);
		int cl = r.nextInt(numcols);
		success = example.addWord(wordBank[spot], rw, cl, dx, dy);
		if (success){
		    wordsUsed.add(wordBank[spot]);
		    trynum = effort;
		}
		trynum++;
	    }
	   
	}
    }

    public static void printFinal(boolean ansKey, WordSearch example, ArrayList<String> wordsUsed){
	if (ansKey == true){
	    System.out.println(example.toString());
	    System.out.println(wordsUsed);
	} else {
	    example.fillEmpty();
	    System.out.println(example.toString());
	    System.out.println(wordsUsed);
	}
    }

    public static void main(String[]args){

	try {
	    int numrows = Integer.parseInt(args[0]);
	    int numcols = Integer.parseInt(args[1]);
	    int effort = 10;
	    int howManyWords = 20;
	    boolean ansKey = false;
	    
	    try {
		if (Integer.parseInt(args[3]) == 1){
		    ansKey = true;
		}
	    } catch (Exception e) {}

	    Random r = new Random();

	    try {
		int seed = Integer.parseInt(args[2]);
	        r = new Random(seed);
	    } catch (Exception e) {}

	    ArrayList<String> wordsUsed = new ArrayList<String>();

	    String[] wordBank = WordSearch.doIt();

	    WordSearch example = new WordSearch(numrows,numcols);

	    addWordInDriver(example, numrows, numcols, r, wordsUsed, wordBank, effort, howManyWords);
        
	    printFinal(ansKey, example, wordsUsed);

	} catch (Exception e){
	    System.out.println("\nPlease call Driver in the following format:\n\n\tDriver rows cols [randomSeed [answers] ]\n\nrows and cols should be integers.\nrandomSeed should be an integer.\nanswers should be used only if randomSeed is used and can only be the value 1 (for true).\n");
	}
	
    }
	
}
