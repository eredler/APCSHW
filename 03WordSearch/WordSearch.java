import java.util.*;
import java.io.*;

public class WordSearch{

    private char[][] data;
      
    //
    //create wordList 
    //
    public static String[] doIt(){
	ArrayList<String> lines = new ArrayList<String>();
	 try{
	     Scanner sc = new Scanner(new File("wordList.rtf"));
	     while (sc.hasNextLine()) {
		 lines.add(sc.nextLine());
	     }	    
	     String[] arr = lines.toArray(new String[lines.size()]);
	     //   System.out.println(lines);
	     return arr;
	 }
	 catch (FileNotFoundException e){
	     System.out.println("file not found");
	     String[] arr = lines.toArray(new String[lines.size()]);
	     return arr;
	 }
	 	
    }
    
    //
    //initialize blank word search
    //
    public WordSearch(int rows, int cols){
	data = new char[rows][cols];
	clear();
    }

    //
    //clear word search (fill each space with ' ')
    //
    private void clear(){
	for (int i = 0; i < data.length; i++){
	    for (int x = 0; x < data[i].length; x++){
		data[i][x] = '.';
	    }
	}
    }

    //
    //turn word search into a printable string
    //
    public String toString(){
	String ans = "";

	for (int i = 0; i < data.length; i++){
	    for (int x = 0; x < data[i].length; x++){
		ans += data[i][x] + " ";
	    }
	    ans += "\n";
	}

	return ans;
    }

    //
    //check if word fits starting at (row,col) horizontally
    //
    public boolean checkWordHorizontal(String word, int row, int col){
	boolean ans = true;
	System.out.println(word + " starting at " + row + " " + col);
	for (int i = 0; i < word.length(); i++){
	    try{
		if (data[row][col+i] != '.' && data[row][col+i] != word.charAt(i)){
		    ans = false;
		    System.out.println("doesn't work " + word + " row: " + row + " col: " + (col+i));
		    System.out.println();
		     break;
		} else {
		    System.out.println("works so far " + word + " row: " + row + " col: " + (col+i));
		}
		
	    }
	    catch (IndexOutOfBoundsException e){
		ans = false;
		System.out.println("exception " + word + " row: " + row + " col: " + (col+i));
		System.out.println();
		break;
	    }
	   
	}
	return ans;
    }

    //
    //check if word fits starting at (row,col) vertically
    //
     public boolean checkWordVertical(String word, int row, int col){
	boolean ans = true;
	
	for (int i = 0; i < word.length(); i++){
	    if (data[row+i][col] != ' ' && data[row+i][col] != word.charAt(i)){
		ans = false;
		i = word.length();
	    }
	}
	return ans;
    }

    //
    //check if word fits starting at (row,col) diagonally
    //
     public boolean checkWordDiagonal(String word, int row, int col){
	boolean ans = true;
	
	for (int i = 0; i < word.length(); i++){
	    if (data[row+i][col+i] != ' ' && data[row+i][col+i] != word.charAt(i)){
		ans = false;
		i = word.length();
	    }
	}

	return ans;
    }

    //
    //tries 50 times (at most) to add a certain word to the word search horizontally
    //
    public boolean addWordHorizontal(String word, int row, int col){
	boolean ans = false;    

	if (checkWordHorizontal(word, row, col)){
	    for (int i = 0; i < word.length(); i++){
		data[row][col+i] = word.charAt(i);
	    }
	    ans = true;
	}

	return ans;
    }

    //ADD 50 TRY CHECKER
    //
    //tries 50 times (at most) to add a certain word to the word search vertically
    //
    public boolean addWordVertical(String word, int row, int col){
	boolean ans = false;

	for (int i = 0; i < word.length(); i++){
	    if (word.length() < data.length - row){
		break;
	    } else if (checkWordVertical(word, row, col)){
		data[row+i][col] = word.charAt(i);
	    } else {
		i = data.length;
	    }
	}	

	return ans;
    }

    //ADD 50 TRY CHECKER
    //
    //tries 50 times (at most) to add a certain word to the word search diagonally
    //
    public boolean addWordDiagonal(String word, int row, int col){
	boolean ans = false;
	
	for (int i = 0; i < word.length(); i++){
	    if (word.length() < data.length - row && word.length() < data[i].length - col){
		break;
	    } else if (checkWordVertical(word, row, col)){
		data[row+i][col+i] = word.charAt(i);
	    } else {
		i = data.length;
	    }
	}

	return ans;
    }

}
