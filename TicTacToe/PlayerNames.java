
package TicTacToe;

import javax.swing.JOptionPane;


public class PlayerNames {
    
    private String player1Name;
    private String player2Name;
    
        
    public String getPlayer1Name(){
        return player1Name;
    }
    
    public String getPlayer2Name(){
        return player2Name;
    }
    
    public void setPlayer1Name(String name){
        
        player1Name = JOptionPane.showInputDialog(null,"Please enter player 1 name","Specify name",JOptionPane.QUESTION_MESSAGE);   
        if(player1Name == null){
            JOptionPane.showMessageDialog(null, "You are player 1.", "TicTacToe", JOptionPane.ERROR_MESSAGE);
            player1Name = "Player 1";
        }
        while(player1Name.trim().isEmpty()){
           player1Name = JOptionPane.showInputDialog(null,"Please enter player 1 name","Specify name",JOptionPane.QUESTION_MESSAGE); 
        }
        
    }
    
    public void setPlayer2Name(String name){  //method for getting player 2 name
        
        player2Name = JOptionPane.showInputDialog(null,"Please enter player 2 name","Specify name",JOptionPane.QUESTION_MESSAGE);   
        if(player2Name == null){
            JOptionPane.showMessageDialog(null, "You are player 2.", "TicTacToe", JOptionPane.ERROR_MESSAGE);
            player2Name = "Player 2";
        }
        while(player2Name.equals(player1Name)){ //currently not working don't know why
           JOptionPane.showMessageDialog(null, "Pick a name different from player 1", "Change name", JOptionPane.ERROR_MESSAGE);
           player2Name = JOptionPane.showInputDialog(null,"Please enter player 2 name","Specify name",JOptionPane.QUESTION_MESSAGE);
           
        }
        while(player2Name.trim().isEmpty()){
            player2Name = JOptionPane.showInputDialog(null,"Please enter player 2 name","Specify name",JOptionPane.QUESTION_MESSAGE); 
        }
        
    }
    
}