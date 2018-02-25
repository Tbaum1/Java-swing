
package hangman;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class GetImage {
    public ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    HangmanGUI hg = new HangmanGUI();
    
    public void GetImage(){
        
        ImageIcon hangman1 = new ImageIcon("src/images/Hangman1.png");
        ImageIcon hangman2 = new ImageIcon("src/images/Hangman2.png");
        ImageIcon hangman3 = new ImageIcon("src/images/Hangman3.png");
        ImageIcon hangman4 = new ImageIcon("src/images/Hangman4.png");
        ImageIcon hangman5 = new ImageIcon("src/images/Hangman5.png");
        ImageIcon hangman6 = new ImageIcon("src/images/Hangman6.png");
        ImageIcon hangman7 = new ImageIcon("src/images/Hangman7.png");
        
        images.add(hangman1);
        images.add(hangman2);
        images.add(hangman3);
        images.add(hangman4);
        images.add(hangman5);
        images.add(hangman6);
        images.add(hangman7);
        
    }
    
    public void getImage(){
        switch(hg.count){ 
        case 1: 
            System.out.println("10");break;  
        case 20: 
            System.out.println("20");break;  
        case 30: 
            System.out.println("30");break;  
        default:System.out.println("Not in 10, 20 or 30");  
        }
    }
    
    public void setImage(){
        
        ImageIcon MyImage = images.get(1);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(hg.lblHangmanImage.getWidth(), hg.lblHangmanImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        hg.lblHangmanImage.setIcon(image);
    }
    
}
