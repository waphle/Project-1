import java.util.Random;
import java.util.Scanner; 

public class Prison {

  //True : the prisoner betrayed.
  //False : the prisoner stayed silent.
  final static boolean BETRAYED = true;
  final static boolean SILENT = false;

  public static void main(String[] args){

    boolean playerChoice, playerLastChoice;
    boolean agentChoice, agentLastChoice;
    int playerYears=0, agentYears=0;
    Scanner in = new Scanner(System.in); 

    Random rand = new Random();

    System.out.println("Welcome to the Prisoner's Dilemma Game!");
    System.out.println("I know how to play this game many ways.");
    System.out.println("Here is a list of the strategies I know:");
    System.out.println("1. Betray at random");
    System.out.println("2. Always betray");
    System.out.println("3. Always be silent");
    System.out.println("4. Tit-for-Tat");
    
    int strategyChoice = 1;
    System.out.println("Enter the number for the strategy that you would like me to use:");
    strategyChoice = in.nextInt();

    if (strategyChoice == 1) {
      System.out.println("Very good. I will betray at random.");
    }
    else if (strategyChoice == 2) {
      System.out.println("Very good. I will always betray.");
    }
    else if (strategyChoice == 3) {
      System.out.println("Very good. I will always keep silent.");
    }
    else if (strategyChoice == 4) {
      System.out.println("Very good. I will play with you using the 'tit-for-tat' strategy.");
    }
    else {
      System.out.println("Sorry, you have made an invalide choice of the game strategy. Please try again. Good luck!");
      return;
    }

    System.out.println("How many rounds would you like to play?");

    int numRounds = 10, currentRound = 1;
    System.out.println("Very good. We will play " + numRounds + " rounds together");

    System.out.println("Round " + currentRound);

    //Strategy 1: Agent using no prior information and choosing at random
    agentChoice = rand.nextBoolean();

    //End code for Strategy 1

    System.out.println("I have made my choice. Do you betray?");
    playerChoice = false;

    System.out.println("I'm not sure what choices were made.");

    playerLastChoice = playerChoice;
    agentLastChoice = agentChoice;

    System.out.println("I'm sorry, I do not know who won.");
    System.out.println("I'm sorry, I do not yet know how to play multiple rounds.");
    System.out.println("Game Over");
  }
}