import java.util.*;
import java.io.*;

public class WordSearch{

    private char[][] data; 
    Random r = new Random();
      
    //
    //create wordList 
    //
    public static String[] doIt(String fileName){
	ArrayList<String> lines = new ArrayList<String>();
	String[] arr = new String[lines.size()];
	try{
	    Scanner sc = new Scanner(new File(fileName));
	    while (sc.hasNextLine()) {
		lines.add(sc.nextLine());
	    }
	    arr = lines.toArray(new String[lines.size()]);
	    return arr;
	}
	catch (FileNotFoundException e){
	    System.out.println("file not found");
	    arr = lines.toArray(new String[lines.size()]);
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
		if (dx == 0 && dy == 0) {
		    ans = false;
		    break;
		} else if (data[row+dy*i][col+dx*i] != '.' && data[row+dy*i][col+dx*i] != word.charAt(i)){
		    ans = false;
		    break;
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
    //tries 50 times (at most) to add a word in the direction dx,dy
    //
    public boolean addWord(String word, int row, int col, int dx, int dy){
	boolean ans = false;    
	//	System.out.println(word);
	try{
	    if (checkWord(word, row, col, dx, dy)){
		//  System.out.println("success");
		for (int i = 0; i < word.length(); i++){
		    //	System.out.println(i);
		    data[row+dx*i][col+dy*i] = word.charAt(i);
		}
		ans = true;
	    }
	} catch (IndexOutOfBoundsException e) {
	    ans = false;
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
