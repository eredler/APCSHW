import java.util.*;

public class Driver {

    public static void addWordInDriver(WordSearch example, int numrows, int numcols, Random r, ArrayList<String> wordsUsed, String[] wordBank, int effort){
	for (int i = 0; i < wordBank.length; i++){
	    boolean success = false;
	    int trynum = 0;
	    int spot = r.nextInt(wordBank.length);
	    if (wordBank[spot].length() <= 3){
		i = wordBank.length;
	    } else  if (wordsUsed.contains(wordBank[spot])){
		i = wordBank.length;	i = wordBank.length;
	    } else {
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
    }

    public static void printFinal(boolean ansKey, WordSearch example){
	if (ansKey == true){
	    System.out.println(example.toString());
	} else {
	    example.fillEmpty();
	    System.out.println(example.toString());
	}
    }

    public static String[] loadWordsFromFile(String fileName, String[] wordBank){
        wordBank = WordSearch.doIt(fileName);
	return wordBank;
    }

    public static void convertWordsUsed(ArrayList<String> wordsUsed){
	for (int rowOn = 0; rowOn < wordsUsed.size()/4; rowOn++){
	    System.out.format("%15s %15s %15s %15s %n", wordsUsed.get(4*rowOn), wordsUsed.get(rowOn+1+3*rowOn), wordsUsed.get(rowOn*2+2+2*rowOn), wordsUsed.get(rowOn*3+3+rowOn));
	}
	int remaining = wordsUsed.size() - (wordsUsed.size()/4)*4;
	switch (remaining){
	case 0:
	    break;
	case 1: 
	    System.out.format("%15s %n", wordsUsed.get(wordsUsed.size()-1));
	    break;
	case 2: 
	    System.out.format("%15s %15s %n", wordsUsed.get(wordsUsed.size()-2), wordsUsed.get(wordsUsed.size()-1));
	    break;
	case 3: 
	    System.out.format("%15s %15s %15s %n", wordsUsed.get(wordsUsed.size()-3), wordsUsed.get(wordsUsed.size()-2), wordsUsed.get(wordsUsed.size()-1));
	    break;
	}
    }


    public static void main(String[]args){

	try {
	    int numrows = Integer.parseInt(args[0]);
	    int numcols = Integer.parseInt(args[1]);
	    int effort = 10;
	    boolean ansKey = false;	    
	    ArrayList<String> wordsUsed = new ArrayList<String>();
	    String[] wordBank = new String[0];
	    wordBank = loadWordsFromFile("wordListCopy.txt", wordBank);      
	    WordSearch example = new WordSearch(numrows,numcols);
	    Random r = new Random();
	    
	    try {
		if (Integer.parseInt(args[3]) == 1){
		    ansKey = true;
		}
	    } catch (Exception e) {}


	    try {
		int seed = Integer.parseInt(args[2]);
	        r = new Random(seed);
	    } catch (Exception e) {}


	    addWordInDriver(example, numrows, numcols, r, wordsUsed, wordBank, effort);
        
	    printFinal(ansKey, example);
	    convertWordsUsed(wordsUsed);
	} catch (Exception e){
	    System.out.println("\nPlease call Driver in the following format:\n\n\tDriver rows cols [randomSeed [answers] ]\n\nrows and cols should be integers.\nrandomSeed should be an integer.\nanswers should be used only if randomSeed is used and can only be the value 1 (for true).\n");
	}
	
    }
	
}
