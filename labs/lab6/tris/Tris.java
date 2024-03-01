public class Tris {
    private char[][] cell;
    
    /**
     * Costruttore vuoto, inizializza l'array bidimensionale cell
     */
    public Tris(){
        cell= new char[3][3];

        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                cell[i][j]='.';
        
    }

    /**
     * toString()
     * @return la stringa che permette di visualizzare il gioco
     */
    public String toString(){
        String s="";
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++)
                s+= " | " + cell[i][j];
            s+=" |\n";
        }
        return s;
    }

    /**
     * setCharInPosition()
     * @return false se la cella selezionata è già occupata
     */
    public boolean setCharInPosition(int row, int column, char c) throws IllegalArgumentException{
        if(row>2 || column > 2)
            throw new IllegalArgumentException();
        else if(cell[row][column]=='.'){
            cell[row][column] = c;
            return true;
        }else
            return false;
    }

    /**
     * getCharInPosition()
     * @return il valore della cella richiesta
     */
    public char getCharInPosition(int row, int column) throws IllegalArgumentException{
        if(row>2 || column > 2)
            throw new IllegalArgumentException();
        else 
            return cell[row][column];
    }

    /**
     * getCount()
     * @return il numero di celle occupate nella matrice
     */
    public int getCount(){
        int count=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(cell[i][j] != '.')
                    count++;
            }
        }
        return count;
    }

    /**
     * isWinning()
     * @param c, ovvero il giocatore, questo parametro può assumere solo due valori: 'x' oppure 'o'
     * @return true se il carattere selezionato ha vinto la partita oppure no
     */
    public boolean isWinning(char c){
        if(checkColumn(c)) return true;
        if(checkRow(c)) return true;
        if(checkDiagonal(c)) return true;
        return false;
    }

    private boolean checkRow(char c){
        if(cell[0][0] == c && cell[0][1] == c && cell[0][2] == c)
            return true;
        if(cell[1][0] == c && cell[1][1] == c && cell[1][2] == c)
            return true;
        if(cell[2][0] == c && cell[2][1] == c && cell[2][2] == c)
            return true;
        return false;

    }
    
    private boolean checkColumn(char c){
        if(cell[0][0] == c && cell[1][0] == c && cell[2][0] == c)
            return true;
        if(cell[0][1] == c && cell[1][1] == c && cell[2][1] == c)
            return true;
        if(cell[0][2] == c && cell[1][2] == c && cell[2][2] == c)
            return true;
        return false;
    }

    private boolean checkDiagonal(char c){
        if(cell[0][0] == c && cell[1][1] == c && cell[2][2] == c)
            return true;
        if(cell[2][0] == c && cell[1][1] == c && cell[0][2] == c)
            return true;
        return false;
    }
}
