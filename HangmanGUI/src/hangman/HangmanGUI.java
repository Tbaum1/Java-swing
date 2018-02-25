package hangman;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.ir.Symbol;

public class HangmanGUI extends javax.swing.JFrame {
    
    static ArrayList<String> words = new ArrayList<String>();
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    char[] correct = new char[26];
    char[] wrong = new char[26];
    static Random generator = new Random();
    String word;
    String secret;
    int attempts = 9;
    char guess;
    private StringBuilder sb = new StringBuilder();
    int misses = 6;
    //GetImage gi = new GetImage();
    int count = 0;
    
    
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
            java.util.logging.Logger.getLogger(HangmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HangmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HangmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HangmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HangmanGUI().setVisible(true);
            }
        });
    }
    
    public HangmanGUI() {
        initComponents();
        buildSymbols();
        selectImage();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        panelBoard.setBackground(Color.DARK_GRAY);
        panelLetters.setBackground(Color.DARK_GRAY);
        lblWrong.setBackground(new Color(0,102,102));
        
    }
    
    public void selectImage(){
        ImageIcon MyImage = images.get(count);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblHangmanImage.getWidth(), lblHangmanImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        lblHangmanImage.setIcon(image);
    }
    
    public void buildSymbols(){
        ImageIcon hangman1 = new ImageIcon("src/images/Hangman1.png");
        ImageIcon hangman2 = new ImageIcon("src/images/Hangman2.png");
        ImageIcon hangman3 = new ImageIcon("src/images/Hangman3.png");
        ImageIcon hangman4 = new ImageIcon("src/images/Hangman4.png");
        ImageIcon hangman5 = new ImageIcon("src/images/Hangman5.png");
        ImageIcon hangman6 = new ImageIcon("src/images/Hangman6.png");
        ImageIcon hangman7 = new ImageIcon("src/images/Hangman7.png");
        ImageIcon hangman8 = new ImageIcon("src/images/Hangman8.png");
        
        images.add(hangman1);
        images.add(hangman2);
        images.add(hangman3);
        images.add(hangman4);
        images.add(hangman5);
        images.add(hangman6);
        images.add(hangman7);
        images.add(hangman8);
        
    }
    
    public void createWords(){
        boolean cont = true;
        String addWord;
        
        while(cont == true){
            if(JOptionPane.showConfirmDialog(null, "Would you like to add a word to the list?", "Add word", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                addWord = JOptionPane.showInputDialog(null, "Enter a word to add");
                words.add(addWord);
            } else {
                break;
            }
        }
    }
    
    public String hideWord(){
        word = words.get(generator.nextInt(words.size()));
        for (int i = 0; i < word.length(); i++){
            sb.append("*");
            lblShowWord.setText(sb.toString());

        }
        
        return word;
    }
       
    public void showWord(char c){
        boolean isCorrect = false;
        
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == c){
                correct[i] = c;
                sb.setCharAt(i, c);
                isCorrect = true;
            }
            else if(word.charAt(i) != c){
                
            }
        }
        if(isCorrect == true){
            lblCorrect.setText("Correct Guess!!!");
        }
        else if(isCorrect == false){
            misses--;
            count++;
            lblMisses.setText(misses + " Misses left");
            lblCorrect.setText("Incorrect Guess");
            selectImage();
        }
        lblShowWord.setText(sb.toString());
        lblWrong.setText(lblWrong.getText() + c);
        checkIfMatch();
        checkMisses();
    }
    
    public void checkIfMatch(){
        if(sb.toString().contains(word)){
            count = 7;
            selectImage();
            lblA.setEnabled(false);
            lblB.setEnabled(false);
            lblC.setEnabled(false);
            lblD.setEnabled(false);
            lblE.setEnabled(false);
            lblF.setEnabled(false);
            lblG.setEnabled(false);
            lblH.setEnabled(false);
            lblI.setEnabled(false);
            lblJ.setEnabled(false);
            lblK.setEnabled(false);
            lblL.setEnabled(false);
            lblM.setEnabled(false);
            lblN.setEnabled(false);
            lblO.setEnabled(false);
            lblP.setEnabled(false);
            lblQ.setEnabled(false);
            lblR.setEnabled(false);
            lblS.setEnabled(false);
            lblT.setEnabled(false);
            lblU.setEnabled(false);
            lblV.setEnabled(false);
            lblW.setEnabled(false);
            lblX.setEnabled(false);
            lblY.setEnabled(false);
            lblZ.setEnabled(false);
           lblMessage.setText("You guessed the word correct!!");
           lblCorrect.setText("");
           lblMisses.setText("Click start round to play again");
           btnStart.setEnabled(true);
        }
    }
    
    public void checkMisses(){
        if(misses == 0){
            //JOptionPane.showMessageDialog(null, "Game Over, you did not guess the word");
            
            lblA.setEnabled(false);
            lblB.setEnabled(false);
            lblC.setEnabled(false);
            lblD.setEnabled(false);
            lblE.setEnabled(false);
            lblF.setEnabled(false);
            lblG.setEnabled(false);
            lblH.setEnabled(false);
            lblI.setEnabled(false);
            lblJ.setEnabled(false);
            lblK.setEnabled(false);
            lblL.setEnabled(false);
            lblM.setEnabled(false);
            lblN.setEnabled(false);
            lblO.setEnabled(false);
            lblP.setEnabled(false);
            lblQ.setEnabled(false);
            lblR.setEnabled(false);
            lblS.setEnabled(false);
            lblT.setEnabled(false);
            lblU.setEnabled(false);
            lblV.setEnabled(false);
            lblW.setEnabled(false);
            lblX.setEnabled(false);
            lblY.setEnabled(false);
            lblZ.setEnabled(false);
            lblMessage.setText("Game Over, you did not guess the word");
            lblCorrect.setText("");
            lblMisses.setText("Click start round to play again");
            lblShowWord.setText(word);
            btnStart.setEnabled(true);
        }
        
    }
    
    public void resetGame(){
        count = 0;
        misses = 6;
        btnStart.setEnabled(true);
        lblWrong.setText("");
        lblMessage.setText("");
        lblMisses.setText("You get 6 misses");
        sb.delete(0,sb.length());
        lblShowWord.setText("");
        lblCorrect.setText("");
        lblA.setEnabled(true);
        lblB.setEnabled(true);
        lblC.setEnabled(true);
        lblD.setEnabled(true);
        lblE.setEnabled(true);
        lblF.setEnabled(true);
        lblG.setEnabled(true);
        lblH.setEnabled(true);
        lblI.setEnabled(true);
        lblJ.setEnabled(true);
        lblK.setEnabled(true);
        lblL.setEnabled(true);
        lblM.setEnabled(true);
        lblN.setEnabled(true);
        lblO.setEnabled(true);
        lblP.setEnabled(true);
        lblQ.setEnabled(true);
        lblR.setEnabled(true);
        lblS.setEnabled(true);
        lblT.setEnabled(true);
        lblU.setEnabled(true);
        lblV.setEnabled(true);
        lblW.setEnabled(true);
        lblX.setEnabled(true);
        lblY.setEnabled(true);
        lblZ.setEnabled(true);
        selectImage();
    }
    
    public void setWords(){
        words.add("house"); words.add("computer"); words.add("java"); words.add("family"); words.add("dog");
        words.add("truck"); words.add("book"); words.add("school"); words.add("fireplace"); words.add("parade");
        words.add("street"); words.add("soccer"); words.add("hangman"); words.add("college"); words.add("football");
        words.add("cowboys"); words.add("apple"); words.add("shirt"); words.add("blue"); words.add("missouri");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRed = new javax.swing.JPanel();
        lblMinWindow = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        panelLetters = new javax.swing.JPanel();
        lblA = new javax.swing.JLabel();
        lblB = new javax.swing.JLabel();
        lblD = new javax.swing.JLabel();
        lblC = new javax.swing.JLabel();
        lblE = new javax.swing.JLabel();
        lblF = new javax.swing.JLabel();
        lblG = new javax.swing.JLabel();
        lblH = new javax.swing.JLabel();
        lblK = new javax.swing.JLabel();
        lblJ = new javax.swing.JLabel();
        lblI = new javax.swing.JLabel();
        lblV = new javax.swing.JLabel();
        lblU = new javax.swing.JLabel();
        lblT = new javax.swing.JLabel();
        lblS = new javax.swing.JLabel();
        lblR = new javax.swing.JLabel();
        lblQ = new javax.swing.JLabel();
        lblP = new javax.swing.JLabel();
        lblO = new javax.swing.JLabel();
        lblN = new javax.swing.JLabel();
        lblM = new javax.swing.JLabel();
        lblL = new javax.swing.JLabel();
        lblX = new javax.swing.JLabel();
        lblY = new javax.swing.JLabel();
        lblZ = new javax.swing.JLabel();
        lblW = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelBoard = new javax.swing.JPanel();
        lblHangmanImage = new javax.swing.JLabel();
        panelShowGuess = new javax.swing.JPanel();
        lblWrong = new javax.swing.JLabel();
        lblCorrect = new javax.swing.JLabel();
        lblMisses = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        lblShowWord = new javax.swing.JLabel();
        lblGuessWord = new javax.swing.JLabel();
        jMenuBar3 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemNew = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        menuItemAddWord = new javax.swing.JMenuItem();
        menuItemDelete = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman");
        setBackground(new java.awt.Color(0, 0, 153));
        setLocation(new java.awt.Point(500, 350));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(606, 541));
        setResizable(false);
        setSize(new java.awt.Dimension(606, 541));

        panelRed.setBackground(new java.awt.Color(153, 0, 0));

        lblMinWindow.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lblMinWindow.setText("-");
        lblMinWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinWindowMouseClicked(evt);
            }
        });

        lblExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblExit.setText("X");
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });

        lblMessage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(0, 0, 102));
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRedLayout = new javax.swing.GroupLayout(panelRed);
        panelRed.setLayout(panelRedLayout);
        panelRedLayout.setHorizontalGroup(
            panelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMinWindow)
                .addGap(18, 18, 18)
                .addComponent(lblExit)
                .addGap(27, 27, 27))
        );
        panelRedLayout.setVerticalGroup(
            panelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(panelRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExit)
                    .addComponent(lblMinWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(23, 23, 23))
            .addGroup(panelRedLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblA.setForeground(new java.awt.Color(255, 153, 0));
        lblA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblA.setText("A");
        lblA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAMouseClicked(evt);
            }
        });

        lblB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblB.setForeground(new java.awt.Color(255, 153, 0));
        lblB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblB.setText("B");
        lblB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBMouseClicked(evt);
            }
        });

        lblD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblD.setForeground(new java.awt.Color(255, 153, 0));
        lblD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblD.setText("D");
        lblD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDMouseClicked(evt);
            }
        });

        lblC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblC.setForeground(new java.awt.Color(255, 153, 0));
        lblC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblC.setText("C");
        lblC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCMouseClicked(evt);
            }
        });

        lblE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblE.setForeground(new java.awt.Color(255, 153, 0));
        lblE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblE.setText("E");
        lblE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEMouseClicked(evt);
            }
        });

        lblF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblF.setForeground(new java.awt.Color(255, 153, 0));
        lblF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF.setText("F");
        lblF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFMouseClicked(evt);
            }
        });

        lblG.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblG.setForeground(new java.awt.Color(255, 153, 0));
        lblG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblG.setText("G");
        lblG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGMouseClicked(evt);
            }
        });

        lblH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblH.setForeground(new java.awt.Color(255, 153, 0));
        lblH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH.setText("H");
        lblH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHMouseClicked(evt);
            }
        });

        lblK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblK.setForeground(new java.awt.Color(255, 153, 0));
        lblK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblK.setText("K");
        lblK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKMouseClicked(evt);
            }
        });

        lblJ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblJ.setForeground(new java.awt.Color(255, 153, 0));
        lblJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJ.setText("J");
        lblJ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJMouseClicked(evt);
            }
        });

        lblI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblI.setForeground(new java.awt.Color(255, 153, 0));
        lblI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblI.setText("I");
        lblI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIMouseClicked(evt);
            }
        });

        lblV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblV.setForeground(new java.awt.Color(255, 153, 0));
        lblV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblV.setText("V");
        lblV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVMouseClicked(evt);
            }
        });

        lblU.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblU.setForeground(new java.awt.Color(255, 153, 0));
        lblU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblU.setText("U");
        lblU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUMouseClicked(evt);
            }
        });

        lblT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblT.setForeground(new java.awt.Color(255, 153, 0));
        lblT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblT.setText("T");
        lblT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTMouseClicked(evt);
            }
        });

        lblS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblS.setForeground(new java.awt.Color(255, 153, 0));
        lblS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblS.setText("S");
        lblS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSMouseClicked(evt);
            }
        });

        lblR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblR.setForeground(new java.awt.Color(255, 153, 0));
        lblR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblR.setText("R");
        lblR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRMouseClicked(evt);
            }
        });

        lblQ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblQ.setForeground(new java.awt.Color(255, 153, 0));
        lblQ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQ.setText("Q");
        lblQ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQMouseClicked(evt);
            }
        });

        lblP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblP.setForeground(new java.awt.Color(255, 153, 0));
        lblP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblP.setText("P");
        lblP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPMouseClicked(evt);
            }
        });

        lblO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblO.setForeground(new java.awt.Color(255, 153, 0));
        lblO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblO.setText("O");
        lblO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOMouseClicked(evt);
            }
        });

        lblN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblN.setForeground(new java.awt.Color(255, 153, 0));
        lblN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblN.setText("N");
        lblN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNMouseClicked(evt);
            }
        });

        lblM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblM.setForeground(new java.awt.Color(255, 153, 0));
        lblM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblM.setText("M");
        lblM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMMouseClicked(evt);
            }
        });

        lblL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblL.setForeground(new java.awt.Color(255, 153, 0));
        lblL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblL.setText("L");
        lblL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLMouseClicked(evt);
            }
        });

        lblX.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblX.setForeground(new java.awt.Color(255, 153, 0));
        lblX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblX.setText("X");
        lblX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblXMouseClicked(evt);
            }
        });

        lblY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblY.setForeground(new java.awt.Color(255, 153, 0));
        lblY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblY.setText("Y");
        lblY.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblYMouseClicked(evt);
            }
        });

        lblZ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblZ.setForeground(new java.awt.Color(255, 153, 0));
        lblZ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblZ.setText("Z");
        lblZ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblZ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblZMouseClicked(evt);
            }
        });

        lblW.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblW.setForeground(new java.awt.Color(255, 153, 0));
        lblW.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblW.setText("W");
        lblW.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Click a letter to guess");

        javax.swing.GroupLayout panelLettersLayout = new javax.swing.GroupLayout(panelLetters);
        panelLetters.setLayout(panelLettersLayout);
        panelLettersLayout.setHorizontalGroup(
            panelLettersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLettersLayout.createSequentialGroup()
                .addGroup(panelLettersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLettersLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLettersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLettersLayout.createSequentialGroup()
                                .addComponent(lblA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblG)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblI)
                                .addGap(18, 18, 18)
                                .addComponent(lblJ)
                                .addGap(12, 12, 12)
                                .addComponent(lblK))
                            .addGroup(panelLettersLayout.createSequentialGroup()
                                .addComponent(lblL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblQ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblV))))
                    .addGroup(panelLettersLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(lblW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblY)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblZ)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelLettersLayout.setVerticalGroup(
            panelLettersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLettersLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(panelLettersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblA)
                    .addComponent(lblB)
                    .addComponent(lblC)
                    .addComponent(lblD)
                    .addComponent(lblE)
                    .addComponent(lblF)
                    .addComponent(lblG)
                    .addComponent(lblH)
                    .addComponent(lblI)
                    .addComponent(lblJ)
                    .addComponent(lblK))
                .addGap(18, 18, 18)
                .addGroup(panelLettersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblL)
                    .addComponent(lblM)
                    .addComponent(lblN)
                    .addComponent(lblO)
                    .addComponent(lblP)
                    .addComponent(lblQ)
                    .addComponent(lblR)
                    .addComponent(lblS)
                    .addComponent(lblT)
                    .addComponent(lblU)
                    .addComponent(lblV))
                .addGap(18, 18, 18)
                .addGroup(panelLettersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblX)
                    .addComponent(lblY)
                    .addComponent(lblZ)
                    .addComponent(lblW))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4))
        );

        panelBoard.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hangman", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 153, 0))); // NOI18N

        lblHangmanImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelBoardLayout = new javax.swing.GroupLayout(panelBoard);
        panelBoard.setLayout(panelBoardLayout);
        panelBoardLayout.setHorizontalGroup(
            panelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHangmanImage, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );
        panelBoardLayout.setVerticalGroup(
            panelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHangmanImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelShowGuess.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblWrong.setBackground(new java.awt.Color(0, 102, 102));
        lblWrong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWrong.setForeground(new java.awt.Color(255, 153, 0));
        lblWrong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelShowGuessLayout = new javax.swing.GroupLayout(panelShowGuess);
        panelShowGuess.setLayout(panelShowGuessLayout);
        panelShowGuessLayout.setHorizontalGroup(
            panelShowGuessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWrong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelShowGuessLayout.setVerticalGroup(
            panelShowGuessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWrong, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );

        lblCorrect.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCorrect.setForeground(new java.awt.Color(255, 153, 0));
        lblCorrect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblMisses.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMisses.setForeground(new java.awt.Color(255, 153, 0));
        lblMisses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMisses.setText("Click start round to play");

        btnStart.setBackground(new java.awt.Color(0, 0, 153));
        btnStart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStart.setForeground(new java.awt.Color(255, 0, 51));
        btnStart.setText("Start Round");
        btnStart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        lblShowWord.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblShowWord.setForeground(new java.awt.Color(255, 153, 0));
        lblShowWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblGuessWord.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGuessWord.setForeground(new java.awt.Color(255, 153, 0));
        lblGuessWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGuessWord.setText("Guess the Word:");

        jMenuBar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuFile.setText("File");
        menuFile.setToolTipText("");

        menuItemNew.setText("New Game");
        menuItemNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuItemNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuItemNewMouseClicked(evt);
            }
        });
        menuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewActionPerformed(evt);
            }
        });
        menuFile.add(menuItemNew);

        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        menuFile.add(menuItemExit);

        jMenuBar3.add(menuFile);

        menuEdit.setText("Edit");

        menuItemAddWord.setText("Add Word");
        menuItemAddWord.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuItemAddWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAddWordActionPerformed(evt);
            }
        });
        menuEdit.add(menuItemAddWord);

        menuItemDelete.setText("Delete Word");
        menuItemDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuEdit.add(menuItemDelete);

        jMenuBar3.add(menuEdit);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblCorrect)
                        .addGap(18, 18, 18)
                        .addComponent(lblMisses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(panelLetters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelShowGuess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblShowWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblGuessWord, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(btnStart)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(lblGuessWord)
                        .addGap(18, 18, 18)
                        .addComponent(lblShowWord, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStart)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCorrect, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMisses, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelShowGuess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelLetters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        closeProgram();
    }//GEN-LAST:event_lblExitMouseClicked

    private void lblAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAMouseClicked
        lblA.setEnabled(false);
        guess = 'a';
        showWord(guess);
    
    }//GEN-LAST:event_lblAMouseClicked

    private void lblBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBMouseClicked
        lblB.setEnabled(false);
        guess = 'b';
        showWord(guess);
        
    }//GEN-LAST:event_lblBMouseClicked

    private void lblCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCMouseClicked
        lblC.setEnabled(false);
        guess = 'c';
        showWord(guess);
        
    }//GEN-LAST:event_lblCMouseClicked

    private void lblDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDMouseClicked
        lblD.setEnabled(false);
        guess = 'd';
        showWord(guess);
        
    }//GEN-LAST:event_lblDMouseClicked

    private void lblEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEMouseClicked
        lblE.setEnabled(false);
        guess = 'e';
        showWord(guess);
        
    }//GEN-LAST:event_lblEMouseClicked

    private void lblFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFMouseClicked
        lblF.setEnabled(false);
        guess = 'f';
        showWord(guess);
        
    }//GEN-LAST:event_lblFMouseClicked

    private void lblGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGMouseClicked
        lblG.setEnabled(false);
        guess = 'g';
        showWord(guess);
        
    }//GEN-LAST:event_lblGMouseClicked

    private void lblHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHMouseClicked
        lblH.setEnabled(false);
        guess = 'h';
        showWord(guess);
        
    }//GEN-LAST:event_lblHMouseClicked

    private void lblKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKMouseClicked
        lblK.setEnabled(false);
        guess = 'k';
        showWord(guess);
        
    }//GEN-LAST:event_lblKMouseClicked

    private void lblJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJMouseClicked
        lblJ.setEnabled(false);
        guess = 'j';
        showWord(guess);
        
    }//GEN-LAST:event_lblJMouseClicked

    private void lblIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIMouseClicked
        lblI.setEnabled(false);
        guess = 'i';
        showWord(guess);
        
    }//GEN-LAST:event_lblIMouseClicked

    private void lblVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVMouseClicked
        lblV.setEnabled(false);
        guess = 'v';
        showWord(guess);
        
    }//GEN-LAST:event_lblVMouseClicked

    private void lblUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUMouseClicked
        lblU.setEnabled(false);
        guess = 'u';
        showWord(guess);
        
    }//GEN-LAST:event_lblUMouseClicked

    private void lblTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTMouseClicked
        lblT.setEnabled(false);
        guess = 't';
        showWord(guess);
        
    }//GEN-LAST:event_lblTMouseClicked

    private void lblSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSMouseClicked
        lblS.setEnabled(false);
        guess = 's';
        showWord(guess);
        
    }//GEN-LAST:event_lblSMouseClicked

    private void lblRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRMouseClicked
        lblR.setEnabled(false);
        guess = 'r';
        showWord(guess);
        
    }//GEN-LAST:event_lblRMouseClicked

    private void lblQMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQMouseClicked
        lblQ.setEnabled(false);
        guess = 'q';
        showWord(guess);
        
    }//GEN-LAST:event_lblQMouseClicked

    private void lblPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPMouseClicked
        lblP.setEnabled(false);
        guess = 'p';
        showWord(guess);
        
    }//GEN-LAST:event_lblPMouseClicked

    private void lblOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOMouseClicked
        lblO.setEnabled(false);
        guess = 'o';
        showWord(guess);
        
    }//GEN-LAST:event_lblOMouseClicked

    private void lblNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNMouseClicked
        lblN.setEnabled(false);
        guess = 'n';
        showWord(guess);
        
    }//GEN-LAST:event_lblNMouseClicked

    private void lblMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMMouseClicked
        lblM.setEnabled(false);
        guess = 'm';
        showWord(guess);
        
    }//GEN-LAST:event_lblMMouseClicked

    private void lblLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLMouseClicked
        lblL.setEnabled(false);
        guess = 'l';
        showWord(guess);
        
    }//GEN-LAST:event_lblLMouseClicked

    private void lblXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXMouseClicked
       lblX.setEnabled(false);
       guess = 'x';
       showWord(guess);
        
    }//GEN-LAST:event_lblXMouseClicked

    private void lblYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblYMouseClicked
        lblY.setEnabled(false);
        guess = 'y';
        showWord(guess);
        
    }//GEN-LAST:event_lblYMouseClicked

    private void lblZMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblZMouseClicked
        lblZ.setEnabled(false);
        guess = 'z';
        showWord(guess);
        
    }//GEN-LAST:event_lblZMouseClicked

    private void lblWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWMouseClicked
        lblW.setEnabled(false);
        guess = 'w';
        showWord(guess);
        
    }//GEN-LAST:event_lblWMouseClicked

    private void lblMinWindowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinWindowMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_lblMinWindowMouseClicked

    private void menuItemNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemNewMouseClicked
        
    }//GEN-LAST:event_menuItemNewMouseClicked

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        closeProgram();
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void menuItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewActionPerformed
        new HangmanGUI().setVisible(true);
    }//GEN-LAST:event_menuItemNewActionPerformed

    private void menuItemAddWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAddWordActionPerformed
        createWords();
    }//GEN-LAST:event_menuItemAddWordActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        setWords();
        resetGame();
        hideWord();
        btnStart.setEnabled(false);
    }//GEN-LAST:event_btnStartActionPerformed
    
    
    
    public void closeProgram(){
        System.exit(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblB;
    private javax.swing.JLabel lblC;
    private javax.swing.JLabel lblCorrect;
    private javax.swing.JLabel lblD;
    private javax.swing.JLabel lblE;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblF;
    private javax.swing.JLabel lblG;
    private javax.swing.JLabel lblGuessWord;
    private javax.swing.JLabel lblH;
    public javax.swing.JLabel lblHangmanImage;
    private javax.swing.JLabel lblI;
    private javax.swing.JLabel lblJ;
    private javax.swing.JLabel lblK;
    private javax.swing.JLabel lblL;
    private javax.swing.JLabel lblM;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblMinWindow;
    public javax.swing.JLabel lblMisses;
    private javax.swing.JLabel lblN;
    private javax.swing.JLabel lblO;
    private javax.swing.JLabel lblP;
    private javax.swing.JLabel lblQ;
    private javax.swing.JLabel lblR;
    private javax.swing.JLabel lblS;
    private javax.swing.JLabel lblShowWord;
    private javax.swing.JLabel lblT;
    private javax.swing.JLabel lblU;
    private javax.swing.JLabel lblV;
    private javax.swing.JLabel lblW;
    public javax.swing.JLabel lblWrong;
    private javax.swing.JLabel lblX;
    private javax.swing.JLabel lblY;
    private javax.swing.JLabel lblZ;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuItemAddWord;
    private javax.swing.JMenuItem menuItemDelete;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemNew;
    private javax.swing.JPanel panelBoard;
    private javax.swing.JPanel panelLetters;
    private javax.swing.JPanel panelRed;
    private javax.swing.JPanel panelShowGuess;
    // End of variables declaration//GEN-END:variables
}
