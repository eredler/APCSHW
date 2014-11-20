import java.util.*;

public class WordSearch{

    private char[][] data;


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
	    for (int x = 0; i < data[i].length; x++){
		ans += data[i][x] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public boolean checkWordHorizontal(String word, int row, int col){
	boolean ans = true;
	
	for (int i = 0; i < word.length(); i++){
	    if (data[row][col+i] != " " && data[row][col+i] != word.charAt[i]()){
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
	    } else if (data[row][col+i] == " " || data[row][col+i]){
		data[row][col+i] = word.charAt[i]();
	    } else
	    }

	return ans;
    }


    public boolean addWordVertical(String word, int row, int col){
	boolean ans = false;
	
	return ans;
    }


    public boolean addWordDiagonal(String word, int row, int col){
	boolean ans = false;
	
	return ans;
    }


}
