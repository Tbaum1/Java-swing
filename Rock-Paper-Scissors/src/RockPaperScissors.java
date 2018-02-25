
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author antho
 */
public class RockPaperScissors {
    
    public static void main(String[] args){
        
        String user;
        String computer = "" ;
        String userPlay;
        
        Scanner input = new Scanner(System.in);
        Random generator = new Random();
        
        System.out.println("Welcome to Rock, Paper, Scissor ");
        
        int computerHand = generator.nextInt(3);
        
        if(computerHand== 0){
            computer = "rock";
        } else if(computerHand == 1){
            computer = "paper";
        } else if (computerHand == 2){
            computer = "scissor";
        }
        
        System.out.println("Type either: rock, paper, or scissor: ");
        user = input.nextLine().toLowerCase();
        
        if(user.equals(computer)){
            System.out.printf("\nscissor (0), rock (1), paper (2): The computer is %s. You are %s. You tied ", computer, user);
        }
        else if(user.equals("rock") && computer.equals("scissor")){
            System.out.printf("\nscissor (0), rock (1), paper (2): The computer is %s. You are %s. You win ", computer, user);
            
        }
        else if(user.equals("rock") && computer.equals("paper")){
            System.out.printf("\nscissor (0), rock (1), paper (2): The computer is %s. You are %s. You lost ", computer, user);
            
        }
        else if(user.equals("paper") && computer.equals("scissor")){
            System.out.printf("\nscissor (0), rock (1), paper (2): The computer is %s. You are %s. You lost ", computer, user);
            
        }
        else if(user.equals("paper") && computer.equals("rock")){
            System.out.printf("\nscissor (0), rock (1), paper (2): The computer is %s. You are %s. You won ", computer, user);
            
        }
        else if(user.equals("scissor") && computer.equals("paper")){
            System.out.printf("\nscissor (0), rock (1), paper (2): The computer is %s. You are %s. You won ", computer, user);
            
        }
        else if(user.equals("scissor") && computer.equals("rock")){
            System.out.printf("\nscissor (0), rock (1), paper (2): The computer is %s. You are %s. You lost ", computer, user);
            
        }
        else {
            System.out.println("Invalid input ");
        }
            
    } 
    
}

