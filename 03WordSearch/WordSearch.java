import java.util.*;
import java.io.*;

public class WordSearch{

    private char[][] data; 
    Random r = new Random();
      
    //
    //create wordList 
    //
    public static String[] doIt(){
	ArrayList<String> lines = new ArrayList<String>();
	 try{
	     Scanner sc = new Scanner(new File("wordListCopy.txt"));
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
    //check word in direction dx,dy 
    //
    //
    public boolean checkWord(String word, int row, int col, int dx, int dy){
        boolean ans = true;
	    for (int i = 0; i < word.length(); i++){
	         try{
	    	  if (data[row+dy][col+dx] != '.' && data[row+dy][col+dx] != word.charAt(i)){
		        	ans = false;
		        	break;
		          } 
	          	}		
	         }
	         catch (IndexOutOfBoundsException e){
	        	ans = false;
	        	break;
	      }
	return ans;
    }
    
    
    
    //check if word fits starting at (row,col) horizontally
    //
    public boolean checkWordHorizontal(String word, int row, int col, boolean forward){
	boolean ans = true;
	for (int i = 0; i < word.length(); i++){
	    try{	
		if (forward){
		    if (data[row][col+i] != '.' && data[row][col+i] != word.charAt(i)){
			ans = false;
			break;
		    } 
		} else {
		    if (data[row][col-i] != '.' && data[row][col-i] != word.charAt(i)){
			ans = false;
			break;
		    } 
		}		
	    }
	    catch (IndexOutOfBoundsException e){
		ans = false;
		break;
	    }
	   
	}
	return ans;
    }

    //
    //check if word fits starting at (row,col) vertically
    //
    public boolean checkWordVertical(String word, int row, int col, boolean forward){
	boolean ans = true;
        
	for (int i = 0; i < word.length(); i++){
	    try{
		if (forward){
		    if (data[row+i][col] != '.' && data[row+i][col] != word.charAt(i)){
			ans = false;
			break;
		    } 
		} else {
		    if (data[row-i][col] != '.' && data[row-i][col] != word.charAt(i)){
			ans = false;
			break;
		    } 
		}
		
	    }
	    catch (IndexOutOfBoundsException e){
		ans = false;
		break;
	    }
	   
	}
	return ans;
    }

    //
    //check if word fits starting at (row,col) diagonally
    //
    public boolean checkWordDiagonalRight(String word, int row, int col, boolean forward){
	boolean ans = true;
	for (int i = 0; i < word.length(); i++){
	    try{
		if (forward){
		    if (data[row+i][col+i] != '.' && data[row+i][col+i] != word.charAt(i)){
			ans = false;
			break;
		    }
		} else {
		    if (data[row-i][col-i] != '.' && data[row-i][col-i] != word.charAt(i)){
			ans = false;
			break;
		    }
		}
		
	    }
	    catch (IndexOutOfBoundsException e){
		ans = false;
		break;
	    }
	   
	}
	return ans;
    }

    public boolean checkWordDiagonalLeft(String word, int row, int col, boolean forward){
	boolean ans = true;
	for (int i = 0; i < word.length(); i++){
	    try{
		if (forward){
		    if (data[row+i][col-i] != '.' && data[row+i][col-i] != word.charAt(i)){
			ans = false;
			break;
		    }
		} else {
		     if (data[row-i][col+i] != '.' && data[row-i][col+i] != word.charAt(i)){
			ans = false;
			break;
		    }
		}
		
	    }
	    catch (IndexOutOfBoundsException e){
		ans = false;
		break;
	    }
	   
	}
	return ans;
    }

    //
    //tries 50 times (at most) to add a certain word to the word search horizontally
    //
    public boolean addWordHorizontal(String word, int row, int col, boolean forward){
	boolean ans = false;    

	if (checkWordHorizontal(word, row, col,forward)){
	    if (forward){
		for (int i = 0; i < word.length(); i++){
		    data[row][col+i] = word.charAt(i);
		}
		ans = true;
	    } else {
		for (int i = 0; i < word.length(); i++){
		    data[row][col-i] = word.charAt(i);
		}
		ans = true;
	    }
	}

	return ans;
    }

    //ADD 50 TRY CHECKER
    //
    //tries 50 times (at most) to add a certain word to the word search vertically
    //
    public boolean addWordVertical(String word, int row, int col, boolean forward){
	boolean ans = false;

	if (checkWordVertical(word, row, col, forward)){
	    if (forward) {
		for (int i = 0; i < word.length(); i++){
		    data[row+i][col] = word.charAt(i);
		}
		ans = true;
	    } else {
		for (int i = 0; i < word.length(); i++){
		    data[row-i][col] = word.charAt(i);
		}
		ans = true;
	    }
	}
	return ans;
    }

    //ADD 50 TRY CHECKER
    //
    //tries 50 times (at most) to add a certain word to the word search diagonally
    //
    public boolean addWordDiagonalRight(String word, int row, int col, boolean forward){
	boolean ans = false;
	
	if (checkWordDiagonalRight(word, row, col, forward)){
	    if (forward){
		for (int i = 0; i < word.length(); i++){
		    data[row+i][col+i] = word.charAt(i);
		}
		ans = true;
	    } else {
		for (int i = 0; i < word.length(); i++){
		    data[row-i][col-i] = word.charAt(i);
		}
		ans = true;
	    }
	}

	return ans;
    }

    public boolean addWordDiagonalLeft(String word, int row, int col, boolean forward){
	boolean ans = false;
	
	if (checkWordDiagonalLeft(word, row, col, forward)){
	    if (forward){
		for (int i = 0; i < word.length(); i++){
		    data[row+i][col-i] = word.charAt(i);
		}
		ans = true;
	    } else {
		for (int i = 0; i < word.length(); i++){
		    data[row-i][col+i] = word.charAt(i);
		}
		ans = true;
	    }
	}

	return ans;
    }

    //
    //fill empty spots with a random letter a-z
    //
    public void fillEmpty(){
	for (int i = 0; i < data.length; i++){
	    for (int x = 0; x < data[0].length; x++){
		char c = (char)(r.nextInt(26) + 'a');
		if (data[i][x] == '.'){
		data[i][x] = c;
		}
	    }
	}
    }

}
