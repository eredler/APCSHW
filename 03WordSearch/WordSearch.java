import java.util.*;
import java.io.*;

public class WordSearch{

    private char[][] data;
      

    public static void doIt(){
	ArrayList<String> lines = new ArrayList<String>();
	 try{
	     Scanner sc = new Scanner(new File("wordList.rtf"));
	     while (sc.hasNextLine()) {
		 lines.add(sc.nextLine());
	     }	    
	     String[] arr = lines.toArray(new String[0]);
	     //   System.out.println(lines);
	 }
	 catch (FileNotFoundException e){
	     System.out.println("file not found");
	 }
	
    }
    

    public WordSearch(int rows, int cols){
	data = new char[rows][cols];
    }

    private void clear(){
	for (int i = 0; i < data.length; i++){
	    for (int x = 0; i < data[i].length; x++){
		data[i][x] = ' ';
	    }
	}
    }


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


    public boolean checkWordHorizontal(String word, int row, int col){
	boolean ans = true;
	
	for (int i = 0; i < word.length(); i++){
	    if (data[row][col+i] != ' ' && data[row][col+i] != word.charAt(i)){
		ans = false;
		i = word.length();
	    }
	}

	return ans;
    }


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


    public boolean addWordHorizontal(String word, int row, int col){
	boolean ans = false;	
	
	for (int i = 0; i < word.length(); i++){
	    if (word.length() < data[row].length - col){
		break;
	    } else if (checkWordHorizontal(word, row, col)){
		data[row][col+i] = word.charAt(i);
	    } else {
		i = data[row].length;
	    }
	}

	return ans;
    }


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
