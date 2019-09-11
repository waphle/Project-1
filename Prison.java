import java.util.Random;

public class Prison {

  //True : the prisoner betrayed.
  //False : the prisoner stayed silent.
  final static boolean BETRAYED = true;
  final static boolean SILENT = false;
  
  // Hi Jeff, this is a change to demo a commit to branch 'work 2'.
  // Test comment from Jeff. It works!

  public static void main(String[] args){

    boolean playerChoice, playerLastChoice;
    boolean agentChoice, agentLastChoice;
    int playerYears=0, agentYears=0;

    Random rand = new Random();

    System.out.println("Welcome to the Prisoner's Dilemma Game!");
    System.out.println("I know how to play this game many ways.");
    System.out.println("Here is a list of the strategies I know:");
    System.out.println("1. Betray at random");
    System.out.println("Enter the number for the strategy that you would like me to use:");

    System.out.println("I'm sorry, I do not yet know other strategies.");

    int strategyChoice = 1;

    if(strategyChoice == 1){
      System.out.println("Very good. I will betray at random");
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