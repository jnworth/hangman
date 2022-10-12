import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

//James Worth Semester Final Project
//Hangman Game

public class Hangman {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        //store text file into ArrayList

        BufferedReader bufReader = new BufferedReader(new FileReader("wordstoguess.txt"));
        ArrayList<String> listOfLines = new ArrayList<>();
        String line = bufReader.readLine();
        while (line != null) 
        { 
            listOfLines.add(line); 
            line = bufReader.readLine();
        }
        bufReader.close();

//Create Hangman text images        

        String hangman[] = { 
        "-------------" + "\n" +
        "|        |   " + "\n" +
        "|            " + "\n" +
        "|            " + "\n" +
        "|            " + "\n" +
        "|            " + "\n" +
        "|            " + "\n" +
        "|" + "\n" +
        "-------------",
        "-------------" + "\n" +
           "|        |   " + "\n" +
           "|        o   " + "\n" +
           "|            " + "\n" +
           "|            " + "\n" +
           "|            " + "\n" +
           "|            " + "\n" +
           "|" + "\n" +
           "-------------",
           "-------------" + "\n" +
           "|        |   " + "\n" +
           "|        o   " + "\n" +
           "|        |   " + "\n" +
           "|            " + "\n" +
           "|            " + "\n" +
           "|            " + "\n" +
           "|" + "\n" +
           "-------------",
           "-------------" + "\n" +
           "|        |   " + "\n" +
           "|        o   " + "\n" +
           "|        |   " + "\n" +
           "|        |   " + "\n" +
           "|            " + "\n" +
           "|            " + "\n" +
           "|" + "\n" +
           "-------------",
           "-------------" + "\n" +
           "|        |   " + "\n" +
           "|        o   " + "\n" +
           "|        |   " + "\n" +
           "|        |   " + "\n" +
           "|       /    " + "\n" +
           "|            " + "\n" +
           "|" + "\n" +
           "-------------",
           "-------------" + "\n" +
           "|        |   " + "\n" +
           "|        o   " + "\n" +
           "|        |   " + "\n" +
           "|        |   " + "\n" +
           "|       / \\ " + "\n" +
           "|            " + "\n" +
           "|" + "\n" +
           "-------------",
           "-------------" + "\n" +
           "|        |   " + "\n" +
           "|        o   " + "\n" +
           "|        |\\  " + "\n" +
           "|        |   " + "\n" +
           "|       / \\ " + "\n" +
           "|            " + "\n" +
           "|" + "\n" +
           "-------------",
           "-------------" + "\n" +
           "|        |   " + "\n" +
           "|        o   " + "\n" +
           "|       /|\\  " + "\n" +
           "|        |   " + "\n" +
           "|       / \\ " + "\n" +
           "|            " + "\n" +
           "|" + "\n" +
           "-------------"
    };
          
           
        int numWrong = 0;
        boolean weArePlaying = true;
        System.out.println("James Worth Semester Project");
        while(weArePlaying){
            System.out.println(hangman[numWrong]);
            int randomNumber = random.nextInt(listOfLines.size());
            char randomWordToGuess[] = listOfLines.get(randomNumber).toCharArray(); // split the words to guess ex. java -> j,a,v,a
            int ammountOfGuesses = 7; //ammount of wrong guesses
            char playerGuess[] = new char[randomWordToGuess.length]; // "_ _ _ _ _ _ _ _"
            
            for(int i=0; i<playerGuess.length; i++){ // Assign blank dashes at start "_ _ _ _ _ _ _ _"
                playerGuess[i] =  '_';
            } 
            
            boolean wordIsGuessed = false;
          
            String guess = "wrong";
            while(!wordIsGuessed && numWrong != ammountOfGuesses){
                System.out.println("Current Guesses: ");
                print(playerGuess);
                System.out.println("Enter a single character: ");
                char input = scanner.nextLine().charAt(0);
                
                if(input == '-'){
                    wordIsGuessed = true;
                    weArePlaying = false;
                } else{
                    guess = "wrong";
                    for(int i=0; i<randomWordToGuess.length; i++){
                        
                        if(randomWordToGuess[i] == input){
                            playerGuess[i] = input;
                            guess = "right";
                        }
                    }
                    
                    if(guess=="wrong"){
                        numWrong = numWrong+1;
                        System.out.println(hangman[numWrong]);
                    }
                    else{
                        System.out.println(hangman[numWrong]);
                    }

                    if(isTheWordGuessed(playerGuess)){
                        wordIsGuessed = true;
                        System.out.println("Congratulations");
                    }
                }
            } /* End of wordIsGuessed */
            if(!wordIsGuessed){
                System.out.println("You ran out of guesses.");
            }
            
            System.out.println("Would you like to play again? (yes/no) ");
            String choice = scanner.nextLine();
            if(choice.equals("no")){
                weArePlaying = false;
            }
            else{
                numWrong = 0;
            }
            
        }//End of We Are Playing
        
        System.out.println("Game Over!");
    }
    
    public static void print(char array[]){
        for(int i=0; i<array.length; i++){ // Assign blank dashes at start "_ _ _ _ _ _ _ _"
            System.out.print(array[i] + " ");
        } 
        System.out.println();
    }
    
    public static boolean isTheWordGuessed(char[] array){
        boolean condition = true;
        for(int i=0; i<array.length; i++){
            if(array[i] == '_'){
                condition = false;
            }
        }
        return condition;
    }
}