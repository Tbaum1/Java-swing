
package hangman;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import hangman.HangmanGUI;


public class CreateFolder {
    
    static ArrayList<String> myword = HangmanGUI.words;
    
    public CreateFolder(){
        String path = System.getProperty("user.home") + File.separator + "Documents"; 
        path += File.separator + "Hangman Words";
        File customDir = new File(path);

        if (customDir.exists()){
            String word = JOptionPane.showInputDialog(null,"Enter a word","Create Word",JOptionPane.OK_OPTION);
            myword.add(word);
            System.out.println(customDir + " already exists");    
        }else if (customDir.mkdir()){
            System.out.println(customDir + " was created");
        }else{
            System.out.println(customDir + " was not created");
        }
    }
    
}
