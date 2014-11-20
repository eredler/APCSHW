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


    public boolean addWordHorizontal(String word,int row, int col){

    }


    public boolean addWordVertical(String word,int row, int col){

    }


    public boolean addWordDiagonal(String word,int row, int col){

    }


}
