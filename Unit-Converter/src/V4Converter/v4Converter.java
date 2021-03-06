/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package V4Converter;

import java.awt.Toolkit;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Athony Tennenbaum
 */
public class v4Converter extends javax.swing.JFrame {
    
    //constant type double arrays filled in order of: centimeter,feet,inche,kilometer,mile,millimeter,meter,yard
        static final double[] TO_CENTM = {1,30.48,2.54,100000,160935,0.1,100,91.44};
        static final double[] TO_FEET = {0.032808399,1,0.083333333334,3280.839895,5280.019685,0.0032808399,3.280839895,3};
        static final double[] TO_INCHE ={0.3937007874,12,1,39370.07874,63360.23622, 0.0393700787,39.37007874,36} ;
        static final double[] TO_KILOM = {0.00001,0.0003048,0.0000254,1,1.60935,0.000001,0.001,0.0009144 } ;
        static final double[] TO_MILE = {0.0000062137,0.0001893932,0.0000157828,0.6213688756,1,6.213688756E-7,0.0006213689,0.0005681797};
        static final double[] TO_MILIM = {10,304.8,25.4,1000000,1609350,1,1000,914.4};
        static final double[] TO_METER = {0.01,0.3048,0.0254,0.001,1609.35,0.001,1,0.9144}; 
        static final double[] TO_YARD = {0.010936133,0.3333333333,0.0277777778,1093.6132983,1760.0065617,1760.0065617,1};
        
        //constant type double arrays filled in order of: day,hour,milliseconds,minute,month,seconds,week,year
        static final double[] TO_DAY = {1,0.0416666667,1.157407407E-8, 0.0006944444,30.4375,0.0000115741,7,365.25};
        static final double[] TO_HOUR = {24,1,2.777777777E-7,0.0166666667,730.5,0.0002777778,168,8766};
        static final long[] TO_MILLIS = {86400000L,3600000L,1,60000L,2629800000L,1000L,604800000L,31557600000L};
        static final double[] TO_MINUTE = {1440,60,0.0000166667,1,43830,0.0166666667,10080,525960};
        static final double[] TO_MONTH = {0.0328542094,0.0013689254,3.802570537E-10,0.0000228154,1,0.2299794661,12};
        static final double[] TO_SECONDS = {86400,3600,0.001,60,2629800,1,604800,31557600};
        static final double[] TO_WEEK = {0.1428571429,0.005952381,1.653439153E-9,0.0000992063,4.3482142857, 0.0000016534,1,52.178571429};
        static final double[] TO_YEAR = {0.0027378508,0.0001140771,3.168808781E-11,0.0000019013,0.0833333333,3.168808781E-8,0.0191649555,1};
        
        //String userInput = txtField1.getText(); //userInput equals to whatever the user typed in txtField1
                
        //making a String array
        static final String[] LENGTH_UNIT = {"Centimeters", "Feet", "Inches", "Kilometers", "Miles", "Millimeters", "Meters", "Yards"};
        static final String[] TIME_UNIT = {"Days", "Hours", "Milliseconds", "Minutes", "Months", "Seconds", "Weeks", "Years"};
        
        //creating 2 DecimalFormat objects for use on the answer variable later
        public static final DecimalFormat df1 = new DecimalFormat( "#.##" );
        public static final DecimalFormat df2 = new DecimalFormat( "#.0000000" );

    /**
     * Creates new form v4Converter
     */
    public v4Converter() {
        initComponents();
        this.setIcon();  //sets the icon image for the jFrame
        this.setSize(409,294);  //set the starting size of frame
        //setLocationRelativeTo(null); //on startup centers the frame on the screen
        //setLocation(500,350);     //sets location of frame on the screen
        getContentPane().setBackground(java.awt.Color.BLACK);
        comboBoxFrom.setSelectedIndex(0);    //comboBox starts at index 0(first item in list) -1 puts box empty
        comboBoxTo.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAnswer = new javax.swing.JPanel();
        lblAnswer = new javax.swing.JLabel();
        btnConvert = new javax.swing.JButton();
        comboBoxFrom = new javax.swing.JComboBox<>();
        comboBoxTo = new javax.swing.JComboBox<>();
        txtField1 = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblConvertTo = new javax.swing.JLabel();
        lblConvertFrom = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Unit Converter");
        setLocation(new java.awt.Point(500, 350));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(410, 321));

        pnlAnswer.setBackground(new java.awt.Color(204, 255, 204));
        pnlAnswer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 2));

        lblAnswer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAnswer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlAnswerLayout = new javax.swing.GroupLayout(pnlAnswer);
        pnlAnswer.setLayout(pnlAnswerLayout);
        pnlAnswerLayout.setHorizontalGroup(
            pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnswerLayout.createSequentialGroup()
                .addComponent(lblAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlAnswerLayout.setVerticalGroup(
            pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAnswerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnConvert.setBackground(new java.awt.Color(204, 0, 0));
        btnConvert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConvert.setForeground(new java.awt.Color(0, 204, 0));
        btnConvert.setText("Convert");
        btnConvert.setActionCommand("Convert To");
        btnConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvertActionPerformed(evt);
            }
        });

        comboBoxFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose One..", "Length Units", "Time Units" }));
        comboBoxFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFromActionPerformed(evt);
            }
        });

        comboBoxTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose One..", " " }));
        comboBoxTo.setToolTipText("");
        comboBoxTo.setEnabled(false);
        comboBoxTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxToActionPerformed(evt);
            }
        });

        txtField1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtField1ActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(0, 204, 0));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(204, 0, 0));
        btnReset.setText("Reset");
        btnReset.setActionCommand("Convert To");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(0, 0, 204));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExit.setForeground(new java.awt.Color(204, 0, 0));
        btnExit.setText("Exit");
        btnExit.setActionCommand("Convert To");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblConvertTo.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        lblConvertTo.setForeground(new java.awt.Color(255, 153, 0));
        lblConvertTo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConvertTo.setText("Convert to");
        lblConvertTo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblConvertFrom.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        lblConvertFrom.setForeground(new java.awt.Color(255, 153, 0));
        lblConvertFrom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConvertFrom.setText("     Convert From");
        lblConvertFrom.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jPanel1.setBackground(new java.awt.Color(255, 102, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Unit Converter");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("-");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblConvertTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtField1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(comboBoxFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConvert)
                        .addGap(50, 50, 50)
                        .addComponent(btnReset)
                        .addGap(42, 42, 42)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(comboBoxTo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblConvertFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblConvertFrom)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset)
                    .addComponent(btnConvert)
                    .addComponent(btnExit))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxTo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblConvertTo)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvertActionPerformed

        String userInput = txtField1.getText(); //userInput equals to whatever the user typed in txtField1
        
        try{
            Integer.parseInt(userInput); //checks to see if the userInput from the txtField1 is an integer if not the catch takes control
            
            if(comboBoxFrom.getSelectedItem().equals(comboBoxTo.getSelectedItem())){  //error msg box if both comboBox's are the same
                    JOptionPane.showMessageDialog(null, "Cannot convert to the same unit type.", "Um, You Forgot Something!!", JOptionPane.INFORMATION_MESSAGE);
                    return;
            }
            
            for(String l: LENGTH_UNIT){ //this goes through array length_units so the if statement can compare
                
                if((comboBoxFrom.getSelectedItem().equals(l)) && comboBoxTo.getSelectedItem().equals("Centimeters")){   //compares the comboBox's so program knows what to do next
                    double answer = (Double.parseDouble(userInput) * TO_CENTM[comboBoxFrom.getSelectedIndex()]) ;   //converts userInput into a type double then makes the unit conversion
                    if((answer %2) == 0 ){  //checking to see if the answer is even or odd using modulo, if even or odd it sets the DecimalFormat for each way
                        lblAnswer.setText(String.valueOf(df1.format(answer)));  //if even setting the text to the value of variable(answer) for the answer field
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   //if answer is odd
                    }
                }
                else if((comboBoxFrom.getSelectedItem().equals(l)) && comboBoxTo.getSelectedItem().equals("Feet")){
                    double answer = (Double.parseDouble(userInput) * TO_FEET[comboBoxFrom.getSelectedIndex()]) ;   //this works for all conversions options to Feet
                    if((answer %2) == 0 ){                                                                         //getSelectedIndex pulls the index number for what is selected at the time
                        lblAnswer.setText(String.valueOf(df1.format(answer)));
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   
                    } 
                }
                else if((comboBoxFrom.getSelectedItem().equals(l)) && comboBoxTo.getSelectedItem().equals("Inches")){
                    double answer = (Double.parseDouble(userInput) * TO_INCHE[comboBoxFrom.getSelectedIndex()]) ;   
                    if((answer %2) == 0 ){
                        lblAnswer.setText(String.valueOf(df1.format(answer)));
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   
                    } 
                }
                else if((comboBoxFrom.getSelectedItem().equals(l)) && comboBoxTo.getSelectedItem().equals("Kilometers")){
                    double answer = (Double.parseDouble(userInput) * TO_KILOM[comboBoxFrom.getSelectedIndex()]) ;   
                    if((answer %2) == 0 ){
                        lblAnswer.setText(String.valueOf(df1.format(answer)));
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   
                    } 
                }
                else if((comboBoxFrom.getSelectedItem().equals(l)) && comboBoxTo.getSelectedItem().equals("Miles")){
                    double answer = (Double.parseDouble(userInput) * TO_MILE[comboBoxFrom.getSelectedIndex()]) ;   
                    if((answer %2) == 0 ){
                        lblAnswer.setText(String.valueOf(df1.format(answer)));
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   
                    }
                }
                else if((comboBoxFrom.getSelectedItem().equals(l)) && comboBoxTo.getSelectedItem().equals("Millimeters")){
                    double answer = (Double.parseDouble(userInput) * TO_MILIM[comboBoxFrom.getSelectedIndex()]) ;   
                    if((answer %2) == 0 ){
                        lblAnswer.setText(String.valueOf(df1.format(answer)));
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   
                    } 
                }
                else if((comboBoxFrom.getSelectedItem().equals(l)) && comboBoxTo.getSelectedItem().equals("Meters")){
                    double answer = (Double.parseDouble(userInput) * TO_METER[comboBoxFrom.getSelectedIndex()]) ;   
                    if((answer %2) == 0 ){
                        lblAnswer.setText(String.valueOf(df1.format(answer)));
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   
                    }
                }
                else if((comboBoxFrom.getSelectedItem().equals(l)) && comboBoxTo.getSelectedItem().equals("Yards")){
                    double answer = (Double.parseDouble(userInput) * TO_YARD[comboBoxFrom.getSelectedIndex()]) ;  
                    if((answer %2) == 0 ){
                        lblAnswer.setText(String.valueOf(df1.format(answer)));
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));  
                    } 
                }
            }     
            for(String s: TIME_UNIT){
                
                if((comboBoxFrom.getSelectedItem().equals(s)) && comboBoxTo.getSelectedItem().equals("Days")){
                    double answer = (Double.parseDouble(userInput) * TO_DAY[comboBoxFrom.getSelectedIndex()]) ;   //converts userInput into a type double then makes the unit conversion
                    if((answer %2) == 0 ){
                        lblAnswer.setText(String.valueOf(df1.format(answer)));  //if answer is even
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   //if answer is odd
                    }
                }
                else if((comboBoxFrom.getSelectedItem().equals(s)) && comboBoxTo.getSelectedItem().equals("Hours")){
                    double answer = (Double.parseDouble(userInput) * TO_HOUR[comboBoxFrom.getSelectedIndex()]) ;   
                    if((answer %2) == 0 ){
                        lblAnswer.setText(String.valueOf(df1.format(answer)));
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   
                    } 
                }
                else if((comboBoxFrom.getSelectedItem().equals(s)) && comboBoxTo.getSelectedItem().equals("Milliseconds")){
                    double answer = (Double.parseDouble(userInput) * TO_MILLIS[comboBoxFrom.getSelectedIndex()]) ;   
                    if((answer %2) == 0 ){
                        lblAnswer.setText(String.valueOf(df1.format(answer)));
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   
                    } 
                }
                else if((comboBoxFrom.getSelectedItem().equals(s)) && comboBoxTo.getSelectedItem().equals("Minutes")){
                    double answer = (Double.parseDouble(userInput) * TO_MINUTE[comboBoxFrom.getSelectedIndex()]) ;   
                    if((answer %2) == 0 ){
                        lblAnswer.setText(String.valueOf(df1.format(answer)));
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   
                    } 
                }
                else if((comboBoxFrom.getSelectedItem().equals(s)) && comboBoxTo.getSelectedItem().equals("Months")){
                    double answer = (Double.parseDouble(userInput) * TO_MONTH[comboBoxFrom.getSelectedIndex()]) ;   
                    if((answer %2) == 0 ){
                        lblAnswer.setText(String.valueOf(df1.format(answer)));
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   
                    }
                }
                else if((comboBoxFrom.getSelectedItem().equals(s)) && comboBoxTo.getSelectedItem().equals("Seconds")){
                    double answer = (Double.parseDouble(userInput) * TO_SECONDS[comboBoxFrom.getSelectedIndex()]) ;   
                    if((answer %2) == 0 ){
                        lblAnswer.setText(String.valueOf(df1.format(answer)));
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   
                    } 
                }
                else if((comboBoxFrom.getSelectedItem().equals(s)) && comboBoxTo.getSelectedItem().equals("Weeks")){
                    double answer = (Double.parseDouble(userInput) * TO_WEEK[comboBoxFrom.getSelectedIndex()]) ;   
                    if((answer %2) == 0 ){
                        lblAnswer.setText(String.valueOf(df1.format(answer)));
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   
                    }
                }
                else if((comboBoxFrom.getSelectedItem().equals(s)) && comboBoxTo.getSelectedItem().equals("Years")){
                    double answer = (Double.parseDouble(userInput) * TO_YEAR[comboBoxFrom.getSelectedIndex()]) ;   
                    if((answer %2) == 0 ){
                        lblAnswer.setText(String.valueOf(df1.format(answer)));
                    }
                    else{
                        lblAnswer.setText(String.valueOf(df2.format(answer)));   
                    } 
                }
            }
        }
        catch(NumberFormatException e){  
           JOptionPane.showMessageDialog(this, "You must type a Number", "HEY IDIOT!!", JOptionPane.INFORMATION_MESSAGE);  //message box for if userInput isn't a double or integer
        }
    }//GEN-LAST:event_btnConvertActionPerformed
    
    //   ******need to add a actionListener******
    private void comboBoxFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFromActionPerformed

        //String lengthUnits[] = {"Centimeters", "Feet", "Inches", "Kilometers", "Miles", "Millimeters", "Meters", "Yards" };  //makes an array called lengthUnits then populates it
        //String timeUnits[] = {"Day", "Hour", "Millisecond", "Minute", "Month", "Seconds", "Week", "Year"};
        if(comboBoxFrom.getSelectedItem().equals("Length Units")){
            comboBoxTo.setEnabled(true);  //set the comboBoxTo to be activated
            comboBoxFrom.setModel( new DefaultComboBoxModel( LENGTH_UNIT ) );
            comboBoxTo.setModel( new DefaultComboBoxModel( LENGTH_UNIT ) );
            //lengthConversion(); 
        }
        else if(comboBoxFrom.getSelectedItem().equals("Time Units")){
            comboBoxTo.setEnabled(true);   //set the comboBoxTo to be activated
            //DefaultComboBoxModel time = new DefaultComboBoxModel(timeUnits);  //makes a new model and fills it from the array timeUnits and will link the 2 comboBox's
            comboBoxFrom.setModel( new DefaultComboBoxModel( TIME_UNIT ) );  //also makes a new model and fills it from the array timeUnits
            comboBoxTo.setModel( new DefaultComboBoxModel( TIME_UNIT ) );   //but doesn't link the oomboBox's
                /**if(comboBoxFrom.getModel().getSelectedItem().equals("Length Units")){
                   lengthConversion(); 
                }*/
        }

    }//GEN-LAST:event_comboBoxFromActionPerformed

    private void comboBoxToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxToActionPerformed

    }//GEN-LAST:event_comboBoxToActionPerformed

    private void txtField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtField1ActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        String comboStart[] = {"Choose one..", "Length Units", "Time Units"};
        lblAnswer.setText(null);   //making the lable clear
        txtField1.setText(null);       //making the textField clear
        DefaultComboBoxModel reset = new DefaultComboBoxModel(comboStart);
        comboBoxFrom.setModel(reset);
        comboBoxTo.setModel(reset);
        comboBoxFrom.setSelectedIndex(0); // starts the comboBox at index 0. type -1 to start it empty
        comboBoxTo.setSelectedIndex(0);
        comboBoxTo.setEnabled(false);
        lblAnswer.setText(null);

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);    //closes the program
    }//GEN-LAST:event_btnExitActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(v4Converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(v4Converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(v4Converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(v4Converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new v4Converter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btnConvert;
    private static javax.swing.JButton btnExit;
    private static javax.swing.JButton btnReset;
    private static javax.swing.JComboBox<String> comboBoxFrom;
    private static javax.swing.JComboBox<String> comboBoxTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JLabel lblAnswer;
    private javax.swing.JLabel lblConvertFrom;
    private javax.swing.JLabel lblConvertTo;
    private javax.swing.JPanel pnlAnswer;
    static javax.swing.JTextField txtField1;
    // End of variables declaration//GEN-END:variables

    private void setIcon() { //method to get the icon image for jFrame
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icon.png"))); 
    }
   
    
}
