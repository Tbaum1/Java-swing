/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;



/**
 *
 * @author antho
 */
public class TicTacToe extends javax.swing.JFrame {
    
    private String startGame = "X";   //game starts with X going first
    private int oneCount = 0; 
    private int twoCount = 0;  //sets scores to zero at begining of game
    private int count = 0;  //my counter for tracking a tie game
    private boolean currentPlayer = true; //player one = true and player two = false
    private String player;  //used for storing value for currentPlayer method
    private String player1Name;  
    private String player2Name;  //used for setting players names
    int win;  //temp value set and determined by the winner of each round to help track who's turn it is when you hit the reset board button so the who's turn display is correct
    PlayerNames names = new PlayerNames();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToe().setVisible(true);
                
            }
        });
    }
    
    public TicTacToe() {
        initComponents();  //calls generated code that initializes components
        gameScore(); //calls gameScore method
        setIcon();  //calls setIcon method
                
    }
      
    private void winGame(){  //method to check who wins
                        
        String b1 = btn1.getText();
        String b2 = btn2.getText();
        String b3 = btn3.getText();
        
        String b4 = btn4.getText();
        String b5 = btn5.getText();
        String b6 = btn6.getText();
        
        String b7 = btn7.getText();
        String b8 = btn8.getText();
        String b9 = btn9.getText();  //string variables that equal the text from the board buttons
        
       if((b1 == "X" && b2 == "X" && b3 == "X") || (b4 == "X" && b5 == "X" && b6 == "X") || (b7 == "X" && b8 == "X" && b9 == "X") //checking all 3 rows to see if they match X
            || (b1 == "X" && b4 == "X" && b7 == "X") || (b2 == "X" && b5 == "X" && b8 == "X") || (b3 == "X" && b6 == "X" && b9 == "X") //checking all 3 columns to see if they match X  
            || (b1 == "X" && b5 == "X" && b9 == "X") || (b3 == "X" && b5 == "X" && b7 == "X")   //check to see if both diaganle directions match X
            || (b1 == "O" && b2 == "O" && b3 == "O") || (b4 == "O" && b5 == "O" && b6 == "O") || (b4 == "O" && b5 == "O" && b6 == "O") //checking all 3 rows to see if they match O
            || (b1 == "O" && b4 == "O" && b7 == "O") || (b2 == "O" && b5 == "O" && b8 == "O") || (b3 == "O" && b6 == "O" && b9 == "O") //checking all 3 columns to see if they match O 
            || (b1 == "O" && b5 == "O" && b9 == "O") || (b3 == "O" && b5 == "O" && b7 == "O")) //check to see if both diaganle directions match O 
        {   
            if(currentPlayer == false){ //after a button is clicked it changes currentPlayer from true or false, so if that player wins they will be temporarly opposite boolean value assigned and this checks that
                JOptionPane.showMessageDialog(this, lblPlayer1Name.getText() + " Wins!!! ", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE); //if player 1 wins it displays this message box
                disableAllButtons();  //calls method to disable all buttons so after a win no more can be pushed
                oneCount++;  //if player 1 wins then the oneCount vairable adds 1 to increase their score
                gameScore();  //increments the score in the display for player 1
                currentPlayer = true; //sets currentPlayer back to true so player 1 will start the next round
                win = 0;  //temp value set to 0 so when the reset borad button is hit the who's turn display can stay current 0 is player 1
            }
            else if(currentPlayer == true){  //
                JOptionPane.showMessageDialog(this, lblPlayer2Name.getText() + " Wins!!! ", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE); //if player 2 wins it displays this message box
                disableAllButtons();
                twoCount++;  //if player 2 wins then the oneCount vairable adds 1 to increase their score
                gameScore();  //increments the score in the display player 2
                currentPlayer = false;  //sets currentPlayer back to true so player 2 will start the next round
                win = 1; //1 is player 2
            }
        }
        else if(count == 9){  //when a button is clicked it adds one to count if count = 9 and no winning condition is met then it is a tie
            JOptionPane.showMessageDialog(this, "Tie Game!! ", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE); //display message for tie game
        }
    }
    
    private void gameScore(){  //method for setting the score in the display
        
        lblPlayer1.setText(String.valueOf(oneCount));  //sets text in the lblPlayer1 with the current score
        lblPlayer2.setText(String.valueOf(twoCount));  //sets text in the lblPlayer2 with the current score
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btn2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btn3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btn4 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        btn5 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btn6 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        btn9 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        btn7 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        btn8 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        lblPlayer1Name = new javax.swing.JLabel();
        lblPlayer2Name = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        lblPlayer1 = new javax.swing.JLabel();
        lblPlayer2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnChangePlayers = new javax.swing.JButton();
        lblWhosTurn = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe");
        setLocation(new java.awt.Point(500, 350));
        setResizable(false);
        setSize(new java.awt.Dimension(711, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(78, 205, 196));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "    TicTacToe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 48))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(78, 205, 196));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn1.setFont(new java.awt.Font("Tahoma", 1, 56)); // NOI18N
        btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn2.setFont(new java.awt.Font("Tahoma", 1, 56)); // NOI18N
        btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn3.setFont(new java.awt.Font("Tahoma", 1, 56)); // NOI18N
        btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn4.setFont(new java.awt.Font("Tahoma", 1, 56)); // NOI18N
        btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn5.setFont(new java.awt.Font("Tahoma", 1, 56)); // NOI18N
        btn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn6.setFont(new java.awt.Font("Tahoma", 1, 56)); // NOI18N
        btn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn9.setFont(new java.awt.Font("Tahoma", 1, 56)); // NOI18N
        btn9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn7.setFont(new java.awt.Font("Tahoma", 1, 56)); // NOI18N
        btn7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn8.setFont(new java.awt.Font("Tahoma", 1, 56)); // NOI18N
        btn8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(78, 205, 196));
        jPanel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblPlayer1Name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPlayer1Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer1Name.setText("Player 1:");
        lblPlayer1Name.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblPlayer1Name.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblPlayer2Name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPlayer2Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer2Name.setText("Player 2:");
        lblPlayer2Name.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jButton11.setText("Reset");

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jButton12.setText("Reset");

        lblPlayer1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblPlayer2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnExit.setText("Exit");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnReset.setText("Reset Board");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnChangePlayers.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnChangePlayers.setText("Change Players");
        btnChangePlayers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnChangePlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePlayersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPlayer1Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPlayer2Name, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(lblPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(147, 147, 147))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnChangePlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPlayer1Name, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(lblPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPlayer2Name, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(lblPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChangePlayers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(220, 220, 220)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        lblWhosTurn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblWhosTurn.setText("Player one's turn");
        lblWhosTurn.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblWhosTurn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblWhosTurn.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel1.add(lblWhosTurn, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Confirm if you want to exit?", "Tic Tac Toe", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION){
            System.exit(0);  //method for the close button, to close the program when the yes option is clicked
        }
        else{
            
        }
    
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnChangePlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePlayersActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Are you sure you want to reset points and change players?", "Warning!!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            lblPlayer1.setText("0");  
            lblPlayer2.setText("0");  //method for changing players and reseting points back to 0 if the yes option is clicked
            oneCount = 0; 
            twoCount = 0;  //reseting the oneCount/twoCount back to 0
            currentPlayer = true;  //resets the currentPlayer back to true or player 1
            names.getPlayer1Name(player1Name);
            names.getPlayer2Name(player2Name);
//            lblPlayer1Name.setText(String.valueOf(names.setPlayer1Name()));
//            lblPlayer2Name.setText(String.valueOf(names.setPlayer2Name()));
            resetAllButtonText();  //calls the resetAllButtonText method
            enableAllButtons();  //calls the enableAlButtons method
            startGame = "X";  //resets the startGame varible to X so player 1 will be X for the new round
            lblWhosTurn.setText(currentPlayer(player));  //the whos turn display is set back to who won the round
            count = 0;
            win=0;
        }
        else{
                
        }
    }//GEN-LAST:event_btnChangePlayersActionPerformed
    
    public void resetAllButtonText(){  //method for clearing the text of all gameboard buttons
        btn1.setText(null);
        btn2.setText(null);
        btn3.setText(null);
        btn4.setText(null);
        btn5.setText(null);
        btn6.setText(null);
        btn7.setText(null);
        btn8.setText(null);
        btn9.setText(null);
    }
    
    public void enableAllButtons(){  //method to activate or enable all gameboard buttons
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
    }
    
    public void disableAllButtons(){  //method to disable or deactivate all gameboard buttons
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }
   
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetAllButtonText();  //calls the resetAllButtonText method
        enableAllButtons();  //calls the enableAlButtons method
        startGame = "X";  //resets the startGame varible to X so player 1 will be X for the new round
        
        count = 0;  //resets my tie game counter to 0
        if(win ==0){  //if win = 0 then it is player 1 turn
            currentPlayer = true;
        }
        else{  //if win = 1 then player 2 turn
            currentPlayer = false;
        }
        lblWhosTurn.setText(currentPlayer(player));  //the whos turn display is set back to who won the round
    }//GEN-LAST:event_btnResetActionPerformed

    private String currentPlayer(String player){  //method to decide whos turn it is
        if(currentPlayer == true){  //player 1 is true
            player = "Player one's turn";
        }
        else{  //if false then player 2 turn
            player = "Player two's turn";
        }
        return player;
    }
    
    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        btn1.setText(startGame);  //sets the gameboard button to X or O depending on whos turn it is
        count++; //my tie game counter add 1 on click
        
        if(startGame.equalsIgnoreCase("X") ){ //if the it is X turn the the gameboard button 
            btn1.setForeground(Color.blue);  //sets the text color to blue
            startGame = "O";                //then sets the startGame variable to O for the next button push
            currentPlayer = false;          //and then changes the currentPlayer to player 2
            lblWhosTurn.setText(currentPlayer(player));  //changes the whos turn display to the next player based on currentPlayer being true or false
            
        }
        else {  //if the startGame variable is O then it
            startGame = "X";   //sets the startGame to X for the next button push
            currentPlayer = true; //and then changes the currentPlayer to player 1
            btn1.setForeground(Color.red); //sets the text color to red
            lblWhosTurn.setText(currentPlayer(player));  //changes the whos turn display to the next player based on currentPlayer being true or false
            
        }
        winGame(); //calls the winGame method to see if anyone won or a tie game
        btn1.setEnabled(false); //deactivates this button
        
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        btn2.setText(startGame);
        count++;
        if(startGame.equalsIgnoreCase("X")){
            btn2.setForeground(Color.blue);
            startGame = "O";
            currentPlayer = false;
            lblWhosTurn.setText(currentPlayer(player));
        }
        else {
            startGame = "X";
            currentPlayer = true;
            btn2.setForeground(Color.red);
            lblWhosTurn.setText(currentPlayer(player));
        }
        winGame();
        btn2.setEnabled(false);
        
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        btn3.setText(startGame);
        count++;
        if(startGame.equalsIgnoreCase("X")){
            btn3.setForeground(Color.blue);
            startGame = "O";
            currentPlayer = false;
            lblWhosTurn.setText(currentPlayer(player));
        }
        else {
            startGame = "X";
            currentPlayer = true;
            btn3.setForeground(Color.red);
            lblWhosTurn.setText(currentPlayer(player));
        }
        winGame();
        btn3.setEnabled(false);
        
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        btn4.setText(startGame);
        count++;
        if(startGame.equalsIgnoreCase("X")){
            btn4.setForeground(Color.blue);
            startGame = "O";
            currentPlayer = false;
            lblWhosTurn.setText(currentPlayer(player));
        }
        else {
            startGame = "X";
            currentPlayer = true;
            btn4.setForeground(Color.red);
            lblWhosTurn.setText(currentPlayer(player));
        }
        winGame();
        btn4.setEnabled(false);
        
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        btn5.setText(startGame);
        count++;
        if(startGame.equalsIgnoreCase("X")){
            btn5.setForeground(Color.blue);
            startGame = "O";
            currentPlayer = false;
            lblWhosTurn.setText(currentPlayer(player));
        }
        else {
            startGame = "X";
            currentPlayer = true;
            btn5.setForeground(Color.red);
            lblWhosTurn.setText(currentPlayer(player));
        }
        winGame();
        btn5.setEnabled(false);
        
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        btn6.setText(startGame);
        count++;
        if(startGame.equalsIgnoreCase("X")){
            btn6.setForeground(Color.blue);
            startGame = "O";
            currentPlayer = false;
            lblWhosTurn.setText(currentPlayer(player));
        }
        else {
            startGame = "X";
            currentPlayer = true;
            btn6.setForeground(Color.red);
            lblWhosTurn.setText(currentPlayer(player));
        }
        winGame();
        btn6.setEnabled(false);
        
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        btn7.setText(startGame);
        count++;
        if(startGame.equalsIgnoreCase("X")){
            btn7.setForeground(Color.blue);
            startGame = "O";
            currentPlayer = false;
            lblWhosTurn.setText(currentPlayer(player));
        }
        else {
            startGame = "X";
            currentPlayer = true;
            btn7.setForeground(Color.red);
            lblWhosTurn.setText(currentPlayer(player));
        }
        winGame();
        btn7.setEnabled(false);
        
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        btn8.setText(startGame);
        count++;
        if(startGame.equalsIgnoreCase("X")){
            btn8.setForeground(Color.blue);
            startGame = "O";
            currentPlayer = false;
            lblWhosTurn.setText(currentPlayer(player));
        }
        else {
            startGame = "X";
            currentPlayer = true;
            btn8.setForeground(Color.red);
            lblWhosTurn.setText(currentPlayer(player));
        }
        winGame();
        btn8.setEnabled(false);
        
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        btn9.setText(startGame);
        count++;
        if(startGame.equalsIgnoreCase("X")){
            btn9.setForeground(Color.blue);
            startGame = "O";
            currentPlayer = false;
            lblWhosTurn.setText(currentPlayer(player));
        }
        else {
            startGame = "X";
            currentPlayer = true;
            btn9.setForeground(Color.red);
            lblWhosTurn.setText(currentPlayer(player));
        }
        winGame();
        btn9.setEnabled(false);
        
    }//GEN-LAST:event_btn9ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        names.getPlayer1Name(player1Name);
        names.getPlayer2Name(player2Name);
        lblPlayer1Name.setText(String.valueOf(names.setPlayer1Name()));
        lblPlayer2Name.setText(String.valueOf(names.setPlayer2Name()));  //when the JFrame for TicTacToe class is opened then it prompts the users to enter their names
          
    }//GEN-LAST:event_formWindowOpened
    
    private void setIcon() { //method to get the icon image for jFrame
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("TictactoeIcon.png"))); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnChangePlayers;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblPlayer1;
    private javax.swing.JLabel lblPlayer1Name;
    private javax.swing.JLabel lblPlayer2;
    private javax.swing.JLabel lblPlayer2Name;
    private javax.swing.JLabel lblWhosTurn;
    // End of variables declaration//GEN-END:variables
}
